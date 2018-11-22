package DAOImplementation;

import DAOInterfaces.SubjectDAO;
import logic.Skill;
import logic.StudentGroup;
import logic.Subject;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubjectDAOImp implements SubjectDAO {
    public void addSubject(Subject subject) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при добавлении предмета", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateSubject(Subject subject) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(subject);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при изменении предмета", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteSubject(Subject subject) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при удалении предмета", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Subject getSubjectByName(String name) throws SQLException {
        Session session = null;
        Subject subject = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subject = session.load(Subject.class, name);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при поиске предмета по наименованию", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subject;
    }

    public Subject getSubjectByID(Long subjectID) throws SQLException {
        Session session = null;
        Subject subject = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subject = session.load(Subject.class, subjectID);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при поиске предмета по идентификатору", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subject;
    }

    public Collection getAllSubjects() throws SQLException {
        Session session = null;
        List subjects = new ArrayList<Subject>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            subjects = session.createQuery("from SUBJECT", Subject.class).list();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при выводе списка всех предметов", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subjects;
    }

    public Collection getAllSubjectsByRequiredSkill(Skill skill) throws SQLException {
        Session session = null;
        List subjects;
        try{
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
