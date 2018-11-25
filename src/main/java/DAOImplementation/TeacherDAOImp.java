package DAOImplementation;

import DAOInterfaces.TeacherDAO;
import logic.Proficiency;
import logic.Subject;
import logic.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAO interface for @Teacher object.
 */
public class TeacherDAOImp implements TeacherDAO {
    
    @Override
    public void addTeacher(Teacher teacher) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(teacher);
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
    public void updateTeacher(Teacher teacher) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(teacher);
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
    public void deleteTeacher(Teacher teacher) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(teacher);
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
    public Teacher getTeacherByID(int teacherID) {
        Session session = null;
        Teacher teacher = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teacher = session.load(Teacher.class, teacherID);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teacher;
    }

    @Override
    public Teacher getTeacherByLastName(String lastName) {
        Session session = null;
        Teacher teacher = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teacher = session.load(Teacher.class, lastName);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teacher;
    }

    @Override
    public List getAllTeachers() {
        Session session = null;
        List teachers = new ArrayList<Subject>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String selectHQL = "FROM Teacher";
            Query query = session.createQuery(selectHQL);
            teachers = query.list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teachers;
    }

    @Override
    public List getTeachersByProficiency(Proficiency proficiency) {
        Session session = null;
        List teachers;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String selectHQL = "SELECT TEACHER_ID FROM TEACHER_PROF WHERE PROF = :prof";
            Query query = session.createQuery(selectHQL).setParameter("prof", proficiency);
            teachers = query.list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teachers;
    }
}
