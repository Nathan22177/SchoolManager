package DAOInterfaces;

import logic.Skill;
import logic.StudentGroup;

import java.sql.SQLException;

public interface SkillDAO {
    public void addSkill(Skill skill) throws SQLException;
    public void updateSkill(String skillName, Skill skill) throws SQLException;
    public void deleteSkill(Skill skill) throws SQLException;
}
