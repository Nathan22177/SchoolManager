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

    LearnClass getLearnClassByID(Long learnClassID);

    List<LearnClass> getAllLearnClasses();

    List<LearnClass> getLearnClassesByTeacher(Teacher teacher);

    List<LearnClass> getLearnClassesBySubject(Subject subject);

    List<LearnClass> getLearnClassesByStudentGroup(StudentGroup studentGroup);
}
