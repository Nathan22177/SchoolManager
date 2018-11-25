package DAOImplementation;

import DAOInterfaces.StudentGroupDAO;
import logic.StudentGroup;
import logic.Subject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for StudentGroup object.
 */
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
    public StudentGroup getGroupByID(int groupID) {
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
            String selectHQL = "FROM StudentGroup";
            Query query = session.createQuery(selectHQL);
            groups = query.list();
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
            String selectHQL = "FROM STUDENT_GROUP WHERE GRADE = :year";
            Query query = session.createQuery(selectHQL).setParameter("year", year);
            groups = query.list();
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
            String selectHQL = "FROM STUDENT_GROUP WHERE STUDENT_FLOW = :flow";
            Query query = session.createQuery(selectHQL).setParameter("flow", flow);
            groups = query.list();
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
}
