import DAO.Imp.*;
import DAO.Interfaces.*;

public class Factory {

    private static LearnClassDAO learnClassDAO = null;
    private static SkillDAO skillDAO = null;
    private static StudentGroupDAO studentGroupDAO = null;
    private static SubjectDAO subjectDAO = null;
    private static TeacherDAO teacherDAO = null;
    private static Factory instance = null;

    /**
     * Implementation of a singleton Factory
     * @return singleton instance of Data Access Object
     */
    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public LearnClassDAO getLearnClassDAO(){
        if (learnClassDAO == null){
            learnClassDAO = new LearnClassDAOImp();
        }
        return learnClassDAO;
    }

    public static SkillDAO getSkillDAO() {
        if (skillDAO == null){
            skillDAO = new SkillDAOImp();
        }
        return skillDAO;
    }

    public static StudentGroupDAO getStudentGroupDAO(){
        if (studentGroupDAO == null){
            studentGroupDAO = new StudentGroupDAOImp();
        }
        return studentGroupDAO;
    }

    public static SubjectDAO getSubjectDAO(){
        if (subjectDAO == null){
            subjectDAO = new SubjectDAOImp();
        }
        return subjectDAO;
    }

    public static TeacherDAO getTeacherDAO(){
        if (teacherDAO == null){
            teacherDAO = new TeacherDAOImp();
        }
        return teacherDAO;
    }
}
