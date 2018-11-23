package DAOInterfaces;

import logic.Proficiency;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

public interface TeacherDAO {
    void addTeacher(Teacher teacher) throws SQLException;

    void updateTeacher(Teacher teacher) throws SQLException;

    void deleteTeacher(Teacher teacher) throws SQLException;

    Teacher getTeacherByID(Long teacherID) throws SQLException;

    Teacher getTeacherByLastName(String lastName) throws SQLException;

    Collection getAllTeachers() throws SQLException;

    Collection getTeachersBySkill(Proficiency proficiency) throws SQLException;
}
