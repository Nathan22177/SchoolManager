package logic;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLASS")
public class Class {
    private Long teacherID;
    private Long subjectID;
    private Long classID;
    private Set attendingGroups;

    public Class() {
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    public Set getAttendingGroups() {
        return attendingGroups;
    }

    public void setAttendingGroups(Set attendingGroups) {
        this.attendingGroups = attendingGroups;
    }

    @Column(name = "SUBJECT_ID")
    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }

    @Column(name = "TEACHER_ID")
    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }

    @Id
    @GeneratedValue
    @Column(name = "CLASS_ID")
    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }
}
