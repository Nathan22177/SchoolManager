import logic.Class;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws SQLException {
        Collection classes = Factory.getInstance().getClassDAO().getAllClasses();

        System.out.println("Все занятия");
        for (Object aClass : classes) {
            Class lesson = (Class) aClass;
            Subject subject = Factory.getSubjectDAO().getSubjectByID(lesson.getSubjectID());
            Teacher teacher = Factory.getTeacherDAO().getTeacherByID(lesson.getTeacherID());
            System.out.println("Занятие по дисциплине : " + subject.getSubjectName() + ". Проводит : " + teacher.getFirstName() + teacher.getLastName());
        }
    }
}
