import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Teacher", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
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
    @JoinTable(name = "TEACHER'S_SKILLSET", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "SKILLS")})
    public Set getSkills(){
        return skills;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id", length = 10, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first name", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last name", length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age", length = 5)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
