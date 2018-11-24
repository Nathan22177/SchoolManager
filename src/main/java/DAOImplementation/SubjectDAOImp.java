package DAOImplementation;

import DAOInterfaces.SubjectDAO;
import logic.Skill;
import logic.Subject;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

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
    public Subject getSubjectByID(Long subjectID) {
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
            subjects = session.createQuery("from SUBJECT", Subject.class).list();
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
            subjects = session.createQuery("from SUBJECT where SKILL_NAME = :skillName").setParameter("skillName", skillName).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subjects;
    }
}