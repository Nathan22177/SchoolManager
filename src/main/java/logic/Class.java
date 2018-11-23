package logic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLASS")
public class Class {
    @Column(name = "TEACHER_ID")
    private Long teacherID;
    @Column(name = "SUBJECT_ID")
    private Long subjectID;
    @Id
    @GeneratedValue
    @Column(name = "CLASS_ID")
    private Long classID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<StudentGroup> attendingGroups = new HashSet<StudentGroup>();

    public Class() {
    }

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

    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }
}
