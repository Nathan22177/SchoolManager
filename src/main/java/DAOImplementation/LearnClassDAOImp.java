package DAOImplementation;

import DAOInterfaces.LearnClassDAO;
import logic.LearnClass;
import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LearnClassDAOImp implements LearnClassDAO {

    @Override
    public void addLearnClass(LearnClass lesson) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateLearnClass(LearnClass lesson) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteLearnClass(LearnClass lesson) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public LearnClass getLearnClassByID(Long learnClassID) {
        Session session = null;
        LearnClass lesson = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            lesson = session.load(LearnClass.class, learnClassID);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lesson;
    }

    @Override
    public List<LearnClass> getAllLearnClasses() {
        Session session = null;
        List<LearnClass> classes = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String selectHql = "FROM LearnClass";
            Query query = session.createQuery(selectHql);
            classes = query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }

        }
        return classes;
    }

    @Override
    public List<LearnClass> getLearnClassesByTeacher(Teacher teacher) {
        Session session = null;
        List<LearnClass> classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long teacherID = teacher.getId();
            classes = session.createQuery("from CLASS where TEACHER_ID = :teacherID").setParameter("teacherID", teacherID).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    @Override
    public List<LearnClass> getLearnClassesBySubject(Subject subject) {
        Session session = null;
        List<LearnClass> classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long subjectID = subject.getSubjectID();
            classes = session.createQuery("from CLASS where SUBJECT_ID = :subjectID").setParameter("subjectID", subjectID).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    @Override
    public List<LearnClass> getLearnClassesByStudentGroup(StudentGroup studentGroup) {
        Session session = null;
        List<LearnClass> classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Long groupID = studentGroup.getGroupID();
            classes = session.createQuery("from CLASS where GROUP_ID = :groupID").setParameter("groupID", groupID).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }
}
