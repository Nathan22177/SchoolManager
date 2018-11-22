package DAOInterfaces;

import logic.StudentGroup;
import logic.Subject;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.Collection;

public interface StudentGroupDAO {
    public void addStudentGroup(StudentGroup studentGroup) throws SQLException;
    public void updateStudentGroup(StudentGroup studentGroup) throws SQLException;
    public void deleteStudentGroup(StudentGroup studentGroup) throws SQLException;
    public StudentGroup getGroupByID(Long groupID) throws SQLException;
    public Collection getAllStudentGroups() throws SQLException;
    public Collection getAllStudentGroupsByYear(int year) throws SQLException;
    public Collection getAllStudentGroupsByFlow(String flow) throws SQLException;
    public Collection getAllStudentGroupsBySubject(Subject subject) throws SQLException;
}
