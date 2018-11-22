package logic;

import javax.persistence.*;

@Entity
@Table(name = "SKILL")
public class Skill {
    private String name;
    private Proficiency skill;

    public Skill(){
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
