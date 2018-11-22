package DAOInterfaces;

import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;


public interface ClassDAO {
    public void addClass(Class lesson) throws SQLException;
    public void updateClass(Long classID, Class lesson) throws SQLException;
    public void deleteClass(Class lesson) throws SQLException;
    public Class getClassByID(Long classID) throws SQLException;
    public Collection getAllClasses() throws SQLException;
    public Collection getClassesByTeacher(Teacher teacher) throws SQLException;
    public Collection getClassesBySubject(Subject subject) throws SQLException;
    public Collection getClassesByStudentGroup(StudentGroup studentGroup) throws SQLException;
}
