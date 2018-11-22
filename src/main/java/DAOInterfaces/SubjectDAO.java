package DAOInterfaces;

import logic.Skill;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;

public interface SubjectDAO {
    public void addSubject(Subject subject) throws SQLException;
    public void updateSubject(Subject subject) throws SQLException;
    public void deleteSubject(Subject subject) throws SQLException;
    public Subject getSubjectByNameS(String name) throws SQLException;
    public Subject getSubjectByID(Long subjectID) throws SQLException;
    public Collection getAllSubjects() throws SQLException;
    public Collection getAllSubjectsByRequiredSkill(Skill skill) throws SQLException;
}
