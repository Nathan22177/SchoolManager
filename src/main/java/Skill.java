import javax.persistence.*;

@Entity
@Table(name = "Skills")
public class Skill {
    private Proficiency skill;

    public Skill(){
    }

    @Column(name = "SKILLS")
    public Proficiency getSkill() {
        return skill;
    }

    public void setSkill(Proficiency skill) {
        this.skill = skill;
    }
}
