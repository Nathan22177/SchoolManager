package DAOImplementation;

import DAOInterfaces.SubjectDAO;
import logic.Skill;
import logic.Subject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for Subject object.
 */
public class SubjectDAOImp implements SubjectDAO {
    
    @Override
    public void addSubject(Subject subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subject);
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
    public void updateSubject(Subject subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(subject);
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
    public void deleteSubject(Subject subject) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subject);
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
    public Subject getSubjectByName(String name) {
        Session session = null;
        Subject subject = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subject = session.load(Subject.class, name);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subject;
    }

    @Override
    public Subject getSubjectByID(int subjectID) {
        Session session = null;
        Subject subject = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subject = session.load(Subject.class, subjectID);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subject;
    }

    @Override
    public List getAllSubjects() {
        Session session = null;
        List subjects = new ArrayList<Subject>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String selectHQL = "FROM Subject";
            Query query = session.createQuery(selectHQL);
            subjects = query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subjects;
    }

    @Override
    public List getAllSubjectsByRequiredSkill(Skill skill) {
        Session session = null;
        List subjects;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String skillName = skill.getName();
            String selectHQL = "FROM SUBJECT WHERE SKILL_NAME = :skillName";
            Query query = session.createQuery(selectHQL).setParameter("skillName", skillName);
            subjects = query.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subjects;
    }
}