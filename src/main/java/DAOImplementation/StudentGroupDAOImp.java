package DAOImplementation;

import DAOInterfaces.StudentGroupDAO;
import logic.StudentGroup;
import logic.Subject;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentGroupDAOImp implements StudentGroupDAO {
    public void addStudentGroup(StudentGroup studentGroup) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(studentGroup);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при добавлении группы студентов", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateStudentGroup(StudentGroup studentGroup) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(studentGroup);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при изменении группы студентов", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteStudentGroup(StudentGroup studentGroup) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(studentGroup);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при удалении группы студентов", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public StudentGroup getGroupByID(Long groupID) throws SQLException {
        Session session = null;
        StudentGroup studentGroup = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studentGroup = session.load(StudentGroup.class, groupID);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при поиске урока по идентификатору", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studentGroup;
    }

    public Collection getAllStudentGroups() throws SQLException {
        Session session = null;
        List groups = new ArrayList<Class>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createQuery("from STUDENT_GROUP", StudentGroup.class).list();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при выводе списка всех студенческих групп", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    public Collection getAllStudentGroupsByYear(int year) throws SQLException {
        Session session = null;
        List groups;
        try{
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

    public Collection getAllStudentGroupsByFlow(String flow) throws SQLException {
        Session session = null;
        List groups;
        try{
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

    public Collection getAllStudentGroupsBySubject(Subject subject) throws SQLException {
        Session session = null;
        List classes;
        try{
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
