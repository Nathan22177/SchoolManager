package DAOInterfaces;

import logic.Proficiency;
import logic.Skill;

import java.sql.SQLException;
import java.util.Collection;

public interface SkillDAO {
    void addSkill(Skill skill) throws SQLException;

    void updateSkill(Skill skill) throws SQLException;

    void deleteSkill(Skill skill) throws SQLException;

    Skill getSkillByName(String skillName) throws SQLException;

    Collection getAllSkillsByProficiency(Proficiency proficiency) throws SQLException;

    Collection getAllSkills() throws SQLException;
}
