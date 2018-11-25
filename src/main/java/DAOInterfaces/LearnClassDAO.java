package DAOInterfaces;


import logic.LearnClass;
import logic.StudentGroup;
import logic.Subject;
import logic.Teacher;

import java.util.List;


public interface LearnClassDAO {
    void addLearnClass(LearnClass lesson);

    void updateLearnClass(LearnClass lesson);

    void deleteLearnClass(LearnClass lesson);

    LearnClass getLearnClassByID(int learnClassID);

    List getAllLearnClasses();

    List getLearnClassesByTeacher(Teacher teacher);

    List getLearnClassesBySubject(Subject subject);

    List getLearnClassesByStudentGroup(StudentGroup studentGroup);
}
