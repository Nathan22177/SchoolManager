package DAOInterfaces;

import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

public interface TeacherDAO {
    public void addTeacher(Teacher teacher) throws SQLException;
    public void updateTeacher(Long teacherID, Teacher teacher) throws SQLException;
    public void deleteTeacher(Teacher teacher) throws SQLException;
    public Teacher getTeacherByID(Long teacherID) throws SQLException;
    public Teacher getTeacherByLastName(String lastName) throws SQLException;
    public Collection getAllTeachersByFirstName(String firstName);
    public Collection getAllTeachersInAgeInterval(int minAge, int maxAge) throws SQLException;
    public Collection getAllTeachers() throws SQLException;
    public Collection getTeachersBySkill() throws SQLException;
}
