package DAOInterfaces;

import logic.Proficiency;
import logic.Skill;

import java.util.List;

/**
 * Data Access Object interface for @Skill object.
 */
public interface SkillDAO {
    void addSkill(Skill skill);

    void updateSkill(Skill skill);

    void deleteSkill(Skill skill);

    Skill getSkillByName(String skillName);

    List getAllSkillsByProficiency(Proficiency proficiency);

    List getAllSkills();
}
