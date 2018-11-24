package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="TEACHER_ID", length = 10, nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", length = 20)
    private String lastName;

    @Column(name = "AGE", length = 5)
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER_SKILLSET", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "SKILLS")})
    private Set<Skill> skills = new HashSet<>();

}
