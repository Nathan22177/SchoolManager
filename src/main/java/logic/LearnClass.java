package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Annotating Hibernate entity.
@Entity

//Passing all typical boilerplate to lombok.
@Data

//Annotating Hibernate table for all classes(lessons/seminars/lectures/etc.).
@Table(name = "LEARN_CLASS")
public class LearnClass {

    //Here we are storing id of a teacher who conducts the class.
    @Column(name = "TEACHER_ID")
    private int teacherID;

    //Here we are storing id of a subject which lesson is about.
    @Column(name = "SUBJECT_ID")
    private int subjectID;

    /*
    * Here we are storing id of conducted lesson, it may come handy for tracking lecture materials
    * that come within this course and are for each part of teh course progressively.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private int learnClassID;

    /**
    * Since there might be MANY classes conducted for EACh attending group, and EACH group may attend
    * several classes we're choosing to relate them as MANY lessons to MANY student groups.
    * This may come handy to creating a schedule for each group respectively, depending on course subject
    * each group should go through.
    */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = StudentGroup.class)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<StudentGroup> attendingGroups = new HashSet<>();

    //Making custom toString() method with parameters from separate objects to print in convenient readable way.
    public String toString(String subjectName, String teacherFirstName, String teacherLastName){
    return "Занятие по дисциплине : " + subjectName + ". Проводит : " + teacherFirstName + teacherLastName;
    }
}
