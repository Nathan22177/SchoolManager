package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "STUDENT_GROUP")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", length = 10, nullable = false)
    private int groupID;

    @Column(name = "GRADE", length = 5)
    private int year;

    @Column(name = "STUDENT_FLOW", length = 5)
    private String flow;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GROUP_COURSES", joinColumns = {@JoinColumn(name = "GROUP_ID")}, inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")})
    private Set<Subject> subjects = new HashSet<>();

}
