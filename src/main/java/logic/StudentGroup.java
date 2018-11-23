package logic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "STUDENT_GROUP")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", length = 10, nullable = false)
    private Long groupID;

    @Column(name = "GRADE", length = 5)
    private int year;
    @Column(name = "STUDENT_FLOW", length = 5)
    private String flow;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GROUP_COURSES", joinColumns = {@JoinColumn(name = "GROUP_ID")}, inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")})
    private Set<Subject> subjects = new HashSet<Subject>();

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

    public void setFlow(String flow) { this.flow = flow; }

    public Set getSubjects() {
        return subjects;
    }

    public void setSubjects(Set subjects) {
        this.subjects = subjects;
    }
}
