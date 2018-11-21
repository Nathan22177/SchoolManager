public class Subject {

    private Long subjectID;
    private String subjectName;
    private Proficiency requiredProficiency; //Skill teacher has to have to be able to teach this subject


    public Subject(){

    }

    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Proficiency getRequiredProficiency() {
        return requiredProficiency;
    }

    public void setRequiredProficiency(Proficiency requiredProficiency) {
        this.requiredProficiency = requiredProficiency;
    }


}
