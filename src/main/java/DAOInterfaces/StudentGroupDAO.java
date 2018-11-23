package DAOInterfaces;

import logic.StudentGroup;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;

public interface StudentGroupDAO {
    void addStudentGroup(StudentGroup studentGroup) throws SQLException;

    void updateStudentGroup(StudentGroup studentGroup) throws SQLException;

    void deleteStudentGroup(StudentGroup studentGroup) throws SQLException;

    StudentGroup getGroupByID(Long groupID) throws SQLException;

    Collection getAllStudentGroups() throws SQLException;

    Collection getAllStudentGroupsByYear(int year) throws SQLException;

    Collection getAllStudentGroupsByFlow(String flow) throws SQLException;

    Collection getAllStudentGroupsBySubject(Subject subject) throws SQLException;
}
