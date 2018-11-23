package logic;

import javax.persistence.*;

@Entity
@Table(name = "SKILL")
public class Skill {
    private String name;
    private Proficiency skill;
    private Long skillID;

    public Skill(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="SKILL_ID", length = 10, nullable = false)
    public Long getId() {
        return skillID;
    }

    public void setSkillID(Long skillID) {
        this.skillID = skillID;
    }

    @Column(name = "SKILL_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SKILL_REQUIRED")
    public Proficiency getSkill() {
        return skill;
    }

    public void setSkill(Proficiency skill) {
        this.skill = skill;
    }
}
