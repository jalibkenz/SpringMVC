package in.kenz.sms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SyllabusYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String syllabusYear;

    @OneToMany(mappedBy = "enrolledSyllabusYear")
    private List<Student> syllabusYearStudents;

    public SyllabusYear() {
    }

    public SyllabusYear(Integer id, String syllabusYear, List<Student> syllabusYearStudents) {
        this.id = id;
        this.syllabusYear = syllabusYear;
        this.syllabusYearStudents = syllabusYearStudents;
    }

    @Override
    public String toString() {
        return "SyllabusYear{" +
                "id=" + id +
                ", departmentName='" + syllabusYear + '\'' +
                ", enrolledStudents=" + syllabusYearStudents +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSyllabusYear() {
        return syllabusYear;
    }

    public void setSyllabusYear(String syllabusYear) {
        this.syllabusYear = syllabusYear;
    }

    public List<Student> getSyllabusYearStudents() {
        return syllabusYearStudents;
    }

    public void setSyllabusYearStudents(List<Student> syllabusYearStudents) {
        this.syllabusYearStudents = syllabusYearStudents;
    }
}
