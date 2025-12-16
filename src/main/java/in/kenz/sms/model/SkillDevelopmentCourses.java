package in.kenz.sms.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SkillDevelopmentCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String skillDevelopmentCourseName;

    @ManyToMany(mappedBy = "appliedSkillDevelopmentCourses")
    private Set<Student> studentsWhoEnrolledForSDC;


    public SkillDevelopmentCourses() {
    }

    public SkillDevelopmentCourses(Integer id, String skillDevelopmentCourseName, Set<Student> studentsWhoEnrolledForSDC) {
        this.id = id;
        this.skillDevelopmentCourseName = skillDevelopmentCourseName;
        this.studentsWhoEnrolledForSDC = studentsWhoEnrolledForSDC;
    }

    @Override
    public String toString() {
        return "SkillDevelopmentCourses{" +
                "id=" + id +
                ", programmingCourseName='" + skillDevelopmentCourseName + '\'' +
                ", codingStudents=" + studentsWhoEnrolledForSDC +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillDevelopmentCourseName() {
        return skillDevelopmentCourseName;
    }

    public void setSkillDevelopmentCourseName(String skillDevelopmentCourseName) {
        this.skillDevelopmentCourseName = skillDevelopmentCourseName;
    }

    public Set<Student> getStudentsWhoEnrolledForSDC() {
        return studentsWhoEnrolledForSDC;
    }

    public void setStudentsWhoEnrolledForSDC(Set<Student> studentsWhoEnrolledForSDC) {
        this.studentsWhoEnrolledForSDC = studentsWhoEnrolledForSDC;
    }
}