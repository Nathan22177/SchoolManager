package DAOImplementation;

import DAOInterfaces.ClassDAO;
import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        Session session = null;
        List classes = new ArrayList<Class>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            classes = session.createQuery("from CLASS", Class.class).list();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Ошибка при выводе списка уроков", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    public Collection getClassesByTeacher(Teacher teacher) throws SQLException {
        Session session = null;
        List classes;
        try{
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

    public Collection getClassesBySubject(Subject subject) throws SQLException {
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

    public Collection getClassesByStudentGroup(StudentGroup studentGroup) throws SQLException {
        Session session = null;
        List classes;
        try{
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
