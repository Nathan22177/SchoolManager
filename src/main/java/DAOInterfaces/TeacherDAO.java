package DAOInterfaces;

import logic.Proficiency;
import logic.Teacher;

import java.util.List;

/**
 * Data Access Object interface for @Teacher object.
 */
public interface TeacherDAO {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacherByID(int teacherID);

    Teacher getTeacherByLastName(String lastName);

    List getAllTeachers();

    List getTeachersByProficiency(Proficiency proficiency);
}
