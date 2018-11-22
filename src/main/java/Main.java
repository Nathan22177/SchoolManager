import logic.Class;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws SQLException {
        Collection classes = Factory.getInstance().getClassDAO().getAllClasses();

        System.out.println("Все занятия");
        Iterator iterator = classes.iterator();
        while (iterator.hasNext()){
            Class lesson = (Class) iterator.next();
            Subject subject = Factory.getSubjectDAO().getSubjectByID(lesson.getSubjectID());
            Teacher teacher = Factory.getTeacherDAO().getTeacherByID(lesson.getTeacherID());
            System.out.println("Занятие по дисциплине : " + subject.getSubjectName() + ". Проводит : " + teacher.getFirstName() + teacher.getLastName());
        }
    }
}
