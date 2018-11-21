import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TEACHER")
public class Teacher {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Set skills = new HashSet();

    public Teacher() {

    }

    public void setSkills(Set skills){
        this.skills = skills;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER'S_SKILLSET", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "SKILLS")})
    public Set getSkills(){
        return skills;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="TEACHER_ID", length = 10, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "AGE", length = 5)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
