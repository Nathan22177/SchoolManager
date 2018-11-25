package DAOInterfaces;

import logic.Skill;
import logic.Subject;

import java.util.List;

/**
 * Data Access Object interface for Subject object.
 */
public interface SubjectDAO {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Subject subject);

    Subject getSubjectByName(String name);

    Subject getSubjectByID(int subjectID);

    List getAllSubjects();

    List getAllSubjectsByRequiredSkill(Skill skill);
}
