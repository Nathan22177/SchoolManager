package DAOImplementation;


import DAOInterfaces.LearnClassDAO;
import logic.LearnClass;
import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for @class/lecture/etc.
 */
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
    public LearnClass getLearnClassByID(int learnClassID) {
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
    public List getAllLearnClasses() {
        Session session = null;
        List classes = new ArrayList<>();
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
    public List getLearnClassesByTeacher(Teacher teacher) {
        Session session = null;
        List classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int teacherID = teacher.getTeacherID();
            String selectHQL = "FROM CLASS WHERE TEACHER_ID = :teacherID";
            Query query = session.createQuery(selectHQL).setParameter("teacherID", teacherID);
            classes = query.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    @Override
    public List getLearnClassesBySubject(Subject subject) {
        Session session = null;
        List classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int subjectID = subject.getSubjectID();
            String selectHQL = "FROM CLASS WHERE SUBJECT_ID = :subjectID";
            Query query = session.createQuery(selectHQL).setParameter("subjectID", subjectID);
            classes = query.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    @Override
    public List getLearnClassesByStudentGroup(StudentGroup studentGroup) {
        Session session = null;
        List classes;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            int groupID = studentGroup.getGroupID();
            String selectHQL = "FROM CLASS WHERE GROUP_ID = :groupID";
            Query query = session.createQuery(selectHQL).setParameter("groupID", groupID);
            classes = query.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }
}
