import java.util.HashSet;
import java.util.Set;

public class StudentGroup {
    private Long groupID;
    private int year;
    private String flow;
    private Set students = new HashSet();
    private Set courses = new HashSet();

    public StudentGroup() {

    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }

    public Set getCourses() {
        return courses;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }
}
