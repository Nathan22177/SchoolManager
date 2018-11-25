package logic;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "LEARN_CLASS")
public class LearnClass {

    @Column(name = "TEACHER_ID")
    private int teacherID;

    @Column(name = "SUBJECT_ID")
    private int subjectID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private int learnClassID;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StudentGroup.class)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<StudentGroup> attendingGroups = new HashSet<>();

    public String toString(String subjectName, String teacherFirstName, String teacherLastName){
    return "Занятие по дисциплине : " + subjectName + ". Проводит : " + teacherFirstName + teacherLastName;
    }
}
