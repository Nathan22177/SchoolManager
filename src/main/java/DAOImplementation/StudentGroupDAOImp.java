package DAOImplementation;

import DAOInterfaces.StudentGroupDAO;
import logic.StudentGroup;
import logic.Subject;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupDAOImp implements StudentGroupDAO {
    
    @Override
    public void addStudentGroup(StudentGroup studentGroup) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(studentGroup);
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
    public void updateStudentGroup(StudentGroup studentGroup) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(studentGroup);
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
    public void deleteStudentGroup(StudentGroup studentGroup) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(studentGroup);
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
    public StudentGroup getGroupByID(Long groupID) {
        Session session = null;
        StudentGroup studentGroup = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studentGroup = session.load(StudentGroup.class, groupID);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studentGroup;
    }

    @Override
    public List getAllStudentGroups() {
        Session session = null;
        List groups = new ArrayList<Class>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createQuery("from STUDENT_GROUP", StudentGroup.class).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public List getAllStudentGroupsByYear(int year) {
        Session session = null;
        List groups;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            groups = session.createQuery("from STUDENT_GROUP where GRADE = :year").setParameter("year", year).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public List getAllStudentGroupsByFlow(String flow) {
        Session session = null;
        List groups;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            groups = session.createQuery("from STUDENT_GROUP where STUDENT_FLOW = :flow").setParameter("flow", flow).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public List getAllStudentGroupsBySubject(Subject subject) {
        Session session = null;
        List classes;
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
}
