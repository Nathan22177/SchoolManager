package DAOImplementation;

import DAOInterfaces.ClassDAO;
import jdk.nashorn.internal.scripts.JO;
import org.hibernate.Session;
import util.HibernateUtil;
import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

public class ClassDAOImp implements ClassDAO {

    public void addClass(Class lesson) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при добавлении урока", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateClass(Long classID, Class lesson) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при обновлении урока", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteClass(Class lesson) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(lesson);
            session.getTransaction().commit();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при удалении урока", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public Class getClassByID(Long classID) throws SQLException {
        Session session = null;
        Class lesson = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            lesson = (Class) session.load(Class.class, classID);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при поиске урока по идентификатору", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return lesson;
    }

    public Collection getAllClasses() throws SQLException {
        return null;
    }

    public Collection getClassesByTeacher(Teacher teacher) throws SQLException {
        return null;
    }

    public Collection getClassesBySubject(Subject subject) throws SQLException {
        return null;
    }

    public Collection getClassesbyStudentGroup(StudentGroup studentGroup) throws SQLException {
        return null;
    }
}
