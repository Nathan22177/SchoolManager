package logic;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SKILL")
public class Skill {

    @Column(name = "SKILL_NAME")
    private String name;

    @Column(name = "SKILL_REQUIRED")
    private Proficiency skill;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID", length = 10, nullable = false)
    private Long skillID;
}
