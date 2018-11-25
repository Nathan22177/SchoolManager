package DAO.Interfaces;

import logic.StudentGroup;
import logic.Subject;

import java.util.List;

/**
 * Data Access Object interface for object describing @StudentGroup.
 */
public interface StudentGroupDAO {
    void addStudentGroup(StudentGroup studentGroup);

    void updateStudentGroup(StudentGroup studentGroup);

    void deleteStudentGroup(StudentGroup studentGroup);

    StudentGroup getGroupByID(int groupID);

    List getAllStudentGroups();

    List getAllStudentGroupsByYear(int year);

    List getAllStudentGroupsByFlow(String flow);

    List getAllStudentGroupsBySubject(Subject subject);
}
