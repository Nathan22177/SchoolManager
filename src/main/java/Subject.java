import javax.persistence.*;

@Entity
@Table(name = "SUBJECT")
public class Subject {

    private Long subjectID;
    private String subjectName;
    private Proficiency requiredProficiency; //Skill teacher has to have to be able to teach this subject


    public Subject(){

    }

    @Id
    @GeneratedValue
    @Column(name = "SUBJECT_ID")
    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }
    @Column(name = "SUBJECT_NAME")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Column(name = "REQUIRED_PROFICIENCY")
    public Proficiency getRequiredProficiency() {
        return requiredProficiency;
    }

    public void setRequiredProficiency(Proficiency requiredProficiency) {
        this.requiredProficiency = requiredProficiency;
    }


}
