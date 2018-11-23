package DAOInterfaces;

import logic.Skill;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface SubjectDAO {
    void addSubject(Subject subject) throws SQLException;

    void updateSubject(Subject subject) throws SQLException;

    void deleteSubject(Subject subject) throws SQLException;

    Subject getSubjectByName(String name) throws SQLException;

    Subject getSubjectByID(Long subjectID) throws SQLException;

    List getAllSubjects() throws SQLException;

    Collection getAllSubjectsByRequiredSkill(Skill skill) throws SQLException;
}
