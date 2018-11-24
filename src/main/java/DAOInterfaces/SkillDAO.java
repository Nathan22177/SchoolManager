package DAOInterfaces;

import logic.Proficiency;
import logic.Skill;

import java.sql.SQLException;
import java.util.Collection;

public interface SkillDAO {
    void addSkill(Skill skill);

    void updateSkill(Skill skill);

    void deleteSkill(Skill skill);

    Skill getSkillByName(String skillName);

    Collection getAllSkillsByProficiency(Proficiency proficiency);

    Collection getAllSkills();
}
