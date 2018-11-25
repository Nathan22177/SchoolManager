package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Annotating Hibernate entity.
@Entity

//Passing typical boilerplate to lombok.
@Data

//Annotating Hibernate table for all teachers.
@Table(name = "TEACHER")
public class Teacher {

    //Here we are declaring id for each teacher.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="TEACHER_ID", length = 10, nullable = false)
    private int teacherID;

    @Column(name = "FIRST_NAME", length = 20)
    private String teacherFirstName;

    @Column(name = "LAST_NAME", length = 20)
    private String teacherLastName;

    /**
     * Since there may be MANY teachers where EACH might be proficient in SEVERAL fields,
     * we're choosing to relate teachers to proficiencies as @ManyToMany.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER_PROF", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "PROF")})
    private Set<Proficiency> teacherProf = new HashSet<>();

}
