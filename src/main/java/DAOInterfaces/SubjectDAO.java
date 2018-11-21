package DAOInterfaces;

import logic.Subject;

import java.sql.SQLException;

public interface SubjectDAO {
    public void addSubject(Subject subject) throws SQLException;
    public void updateSubject(Long subjectID, Subject subject) throws SQLException;
    public void deleteSubject(Subject subject) throws SQLException;
    public Subject getSubjectByNameS(String name) throws SQLException;
    public Subject getSubjectByID(Long subjectID) throws SQLException;
    
}
