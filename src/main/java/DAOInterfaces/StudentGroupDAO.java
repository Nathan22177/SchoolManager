package DAOInterfaces;

import logic.StudentGroup;
import logic.Subject;

import java.sql.SQLException;
import java.util.Collection;

public interface StudentGroupDAO {
    void addStudentGroup(StudentGroup studentGroup);

    void updateStudentGroup(StudentGroup studentGroup);

    void deleteStudentGroup(StudentGroup studentGroup);

    StudentGroup getGroupByID(Long groupID);

    Collection getAllStudentGroups();

    Collection getAllStudentGroupsByYear(int year);

    Collection getAllStudentGroupsByFlow(String flow);

    Collection getAllStudentGroupsBySubject(Subject subject);
}
