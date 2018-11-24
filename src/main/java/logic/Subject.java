package logic;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private Long subjectID;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "REQUIRED_PROFICIENCY")
    private Proficiency requiredProficiency; //logic.Skill teacher has to have to be able to teach this subject

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

    public void setRequiredProficiency(Proficiency requiredProficiency) { this.requiredProficiency = requiredProficiency; }

}
