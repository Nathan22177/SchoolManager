package DAOInterfaces;

import logic.Proficiency;
import logic.Skill;

import java.sql.SQLException;
import java.util.Collection;

public interface SkillDAO {
    public void addSkill(Skill skill) throws SQLException;
    public void updateSkill(String skillName, Skill skill) throws SQLException;
    public void deleteSkill(Skill skill) throws SQLException;
    public Skill getSkillByName(String skillName) throws SQLException;
    public Collection getAllSkillsByProficiency(Proficiency proficiency) throws SQLException;
    public Collection getAllSkills() throws SQLException;
}
