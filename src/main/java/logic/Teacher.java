package logic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEACHER")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setSkills(Set skills){
        this.skills = skills;
    }

    public Set getSkills(){
        return skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
