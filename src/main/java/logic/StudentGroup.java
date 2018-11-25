package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Annotating Hibernate entity.
@Entity

//Passing typical boilerplate to lombok.
@Data

//Declaring a table for groups of students.
@Table(name = "STUDENT_GROUP")
public class StudentGroup {

    /*
     * Here we are storing id of particular group of students, it may come handy for scheduling courses,
     * exams, merging groups into flow, and assigning them to internship.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", length = 10, nullable = false)
    private int groupID;

    @Column(name = "GRADE", length = 5)
    private int year;

    @Column(name = "STUDENT_FLOW", length = 5)
    private String flow;

    /**
    * Since EACH group may (and most probably will) attend SEVERAL courses we're choosing
    * to relate groups to courses (subjects) as ONE group to MANY courses.
    */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GROUP_COURSES", joinColumns = {@JoinColumn(name = "GROUP_ID")}, inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")})
    private Set<Subject> subjects = new HashSet<>();

}
