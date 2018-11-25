package logic;

import lombok.Data;

import javax.persistence.*;

//Annotating Hibernate entity.
@Entity

//Passing all typical boilerplate to lombok.
@Data

//Declaring table for all specific skills (gender history/calculus/artificial intelligence/etc.).
@Table(name = "SKILL")
public class Skill {

    @Column(name = "SKILL_NAME")
    private String name;

    //Generified proficiency associated with particular skill.
    @Column(name = "SKILL_REQUIRED")
    private Proficiency proficiency;

    /*
     * Here we are storing id of particular skill, it may come handy for tracking teachers
     * capable to teach within a very specific fields.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID", length = 10, nullable = false)
    private int skillID;
}
