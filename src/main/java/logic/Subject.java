package logic;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

}
