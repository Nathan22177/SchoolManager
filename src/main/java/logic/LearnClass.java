package logic;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "LEARN_CLASS")
public class LearnClass {

    @Column(name = "TEACHER_ID")
    private Long teacherID;

    @Column(name = "SUBJECT_ID")
    private Long subjectID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private Long learnClassID;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = StudentGroup.class)
    @JoinTable(name = "ATTENDING_GROUPS", joinColumns = {@JoinColumn(name = "TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<StudentGroup> attendingGroups = new HashSet<>();
}
