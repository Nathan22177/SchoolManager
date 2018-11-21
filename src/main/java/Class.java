
import java.util.Set;


public class Class {
    private Long teacherID;
    private Long subjectID;
    private Set attendingGroups;

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
}
