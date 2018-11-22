package DAOInterfaces;

import logic.Skill;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface SubjectDAO {
    public void addSubject(Subject subject) throws SQLException;
    public void updateSubject(Subject subject) throws SQLException;
    public void deleteSubject(Subject subject) throws SQLException;
    public Subject getSubjectByName(String name) throws SQLException;
    public Subject getSubjectByID(Long subjectID) throws SQLException;
    public List getAllSubjects() throws SQLException;
    public Collection getAllSubjectsByRequiredSkill(Skill skill) throws SQLException;
}
