import java.util.HashSet;
import java.util.Set;

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
