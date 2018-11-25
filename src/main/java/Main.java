import logic.LearnClass;
import logic.Subject;
import logic.Teacher;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Demo class for feature-testing.
 */
public class Main {

    public static void main(String[] args) {
        Collection classes = Factory.getInstance().getLearnClassDAO().getAllLearnClasses();

        System.out.println("Все занятия");
        for (Object aClass : classes) {
            LearnClass lesson = (LearnClass) aClass;
            Subject subject = Factory.getSubjectDAO().getSubjectByID(lesson.getSubjectID());
            Teacher teacher = Factory.getTeacherDAO().getTeacherByID(lesson.getTeacherID());
            System.out.println(lesson.toString(subject.getSubjectName(), teacher.getTeacherFirstName(), teacher.getTeacherFirstName()));
        }
    }
}
