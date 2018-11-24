package DAOInterfaces;

import logic.Skill;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface SubjectDAO {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void deleteSubject(Subject subject);

    Subject getSubjectByName(String name);

    Subject getSubjectByID(Long subjectID);

    List getAllSubjects();

    Collection getAllSubjectsByRequiredSkill(Skill skill);
}
