package DAOImplementation;

import DAOInterfaces.SkillDAO;
import logic.Proficiency;
import logic.Skill;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SkillDAOImp implements SkillDAO {
    public void addSkill(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateSkill(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(skill);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteSkill(Skill skill) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(skill);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Skill getSkillByName(String skillName) {
        Session session = null;
        Skill skill = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            skill = session.load(Skill.class, skillName);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return skill;
    }

    public Collection getAllSkillsByProficiency(Proficiency proficiency) {
        Session session = null;
        List skills;
        try{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            skills = session.createQuery("from SKILLS where SKILL_REQUIRED = :prof").setParameter("prof", proficiency).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return skills;
    }

    public Collection getAllSkills() {
        Session session = null;
        List skills = new ArrayList<Skill>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            skills = session.createQuery("from SKILL", Skill.class).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return skills;
    }
}
