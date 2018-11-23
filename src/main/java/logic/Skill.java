package logic;

import javax.persistence.*;

@Entity
@Table(name = "SKILL")
public class Skill {
    @Column(name = "SKILL_NAME")
    private String name;
    @Column(name = "SKILL_REQUIRED")
    private Proficiency skill;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SKILL_ID", length = 10, nullable = false)
    private Long skillID;

    public Long getId() {
        return skillID;
    }

    public void setSkillID(Long skillID) { this.skillID = skillID; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Proficiency getSkill() {
        return skill;
    }

    public void setSkill(Proficiency skill) {
        this.skill = skill;
    }
}
