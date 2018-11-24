package logic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LEARN_CLASS")
public class LearnClass {
    @Column(name = "TEACHER_ID")
    private Long teacherID;
    @Column(name = "SUBJECT_ID")
    private Long subjectID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private Long learnClassID;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StudentGroup.class)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<StudentGroup> attendingGroups = new HashSet<>();

    public Set getAttendingGroups() {
        return attendingGroups;
    }

    public void setAttendingGroups(Set attendingGroups) {
        this.attendingGroups = attendingGroups;
    }

    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }

    public Long getLearnClassID() {
        return learnClassID;
    }

    public void setLearnClassID(Long learnClassID) {
        this.learnClassID = learnClassID;
    }
}
