import logic.LearnClass;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws SQLException {
        Collection classes = Factory.getInstance().getLearnClassDAO().getAllLearnClasses();

        System.out.println("Все занятия");
        for (Object aClass : classes) {
            LearnClass lesson = (LearnClass) aClass;
            Subject subject = Factory.getSubjectDAO().getSubjectByID(lesson.getSubjectID());
            Teacher teacher = Factory.getTeacherDAO().getTeacherByID(lesson.getTeacherID());
            System.out.println("Занятие по дисциплине : " + subject.getSubjectName() + ". Проводит : " + teacher.getFirstName() + teacher.getLastName());
        }
    }
}
