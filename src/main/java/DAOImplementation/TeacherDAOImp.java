package DAOImplementation;

import DAOInterfaces.TeacherDAO;
import logic.Proficiency;
import logic.Subject;
import logic.Teacher;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

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
    public Teacher getTeacherByID(Long teacherID) {
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
            teachers = session.createQuery("from TEACHER", Teacher.class).list();
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
    public List getTeachersBySkill(Proficiency proficiency) {
        Session session = null;
        List teachers;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            teachers = session.createQuery("select TEACHER_ID from TEACHER_SKILLSET where SKILLS = :prof").setParameter("prof", proficiency).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teachers;
    }
}
