package DAOInterfaces;

import logic.Proficiency;
import logic.Teacher;

import java.util.List;

public interface TeacherDAO {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacherByID(Long teacherID);

    Teacher getTeacherByLastName(String lastName);

    List getAllTeachers();

    List getTeachersBySkill(Proficiency proficiency);
}
