package DAOInterfaces;


import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;


public interface ClassDAO {
    void addClass(Class lesson) throws SQLException;

    void updateClass(Class lesson) throws SQLException;

    void deleteClass(Class lesson) throws SQLException;

    Class getClassByID(Long classID) throws SQLException;

    java.util.Collection getAllClasses() throws SQLException;

    Collection getClassesByTeacher(Teacher teacher) throws SQLException;

    Collection getClassesBySubject(Subject subject) throws SQLException;

    java.util.Collection<Class> getClassesByStudentGroup(StudentGroup studentGroup) throws SQLException;
}
