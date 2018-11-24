package DAOInterfaces;

import logic.Proficiency;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

public interface TeacherDAO {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    Teacher getTeacherByID(Long teacherID);

    Teacher getTeacherByLastName(String lastName);

    Collection getAllTeachers();

    Collection getTeachersBySkill(Proficiency proficiency);
}
