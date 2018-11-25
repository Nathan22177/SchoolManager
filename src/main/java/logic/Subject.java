package logic;

import lombok.Data;

import javax.persistence.*;

//Annotating Hibernate entity
@Entity

//Passing typical boilerplate to lombok
@Data

//Declaring a table for subjects
@Table(name = "SUBJECT")
/**
 * This class does not stores neither sets of classes, nor sets of teachers,
 * and used only as a descriptor for courses thus simplifying assignment of teachers
 * and student groups for scheduling.
 */
public class Subject {


    //Here we are storing ID of each course(subject). This may come in handy for scheduling.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private int subjectID;

    //Name of the course respectively
    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    //To simplify assignment of a teacher for particular course
    @Column(name = "REQUIRED_PROFICIENCY")
    private Proficiency requiredProficiency;

}
