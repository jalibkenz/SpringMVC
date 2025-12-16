package in.kenz.sms.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private Long mobileNumber;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Address> addresses;

    @ManyToOne(cascade = CascadeType.ALL)
    private Club club;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "universityRegistrationNumber_id")
    private UniversityRegistrationNumber universityRegistrationNumber;


    //Bidirectional

    @OneToMany(mappedBy = "careTakerOfTheStudent", cascade = CascadeType.ALL)
    private List<CareTaker> careTakers;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "syllabusYear_id")
    private SyllabusYear enrolledSyllabusYear;


    @ManyToMany
    @JoinTable(name = "student_skillDevelopmentCourse",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "skillDevelopmentCourse_id"))
    private Set<SkillDevelopmentCourses> appliedSkillDevelopmentCourses;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id")
    private Aadhaar aadhaar;

    //basic things

    public Student() {
    }

    public Student(Integer id, String studentName, Long mobileNumber, List<Address> addresses, Club club, Set<Course> courses, UniversityRegistrationNumber universityRegistrationNumber, List<CareTaker> careTakers, SyllabusYear enrolledSyllabusYear, Set<SkillDevelopmentCourses> appliedSkillDevelopmentCourses, Aadhaar aadhaar) {
        this.id = id;
        this.studentName = studentName;
        this.mobileNumber = mobileNumber;
        this.addresses = addresses;
        this.club = club;
        this.courses = courses;
        this.universityRegistrationNumber = universityRegistrationNumber;
        this.careTakers = careTakers;
        this.enrolledSyllabusYear = enrolledSyllabusYear;
        this.appliedSkillDevelopmentCourses = appliedSkillDevelopmentCourses;
        this.aadhaar = aadhaar;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", addresses=" + addresses +
                ", club=" + club +
                ", courses=" + courses +
                ", universityRegistrationNumber=" + universityRegistrationNumber +
                ", careTakers=" + careTakers +
                ", enrolledSyllabusYear=" + enrolledSyllabusYear +
                ", appliedSkillDevelopmentCourses=" + appliedSkillDevelopmentCourses +
                ", aadhaar=" + aadhaar +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public UniversityRegistrationNumber getUniversityRegistrationNumber() {
        return universityRegistrationNumber;
    }

    public void setUniversityRegistrationNumber(UniversityRegistrationNumber universityRegistrationNumber) {
        this.universityRegistrationNumber = universityRegistrationNumber;
    }

    public List<CareTaker> getCareTakers() {
        return careTakers;
    }

    public void setCareTakers(List<CareTaker> careTakers) {
        this.careTakers = careTakers;
    }

    public SyllabusYear getEnrolledSyllabusYear() {
        return enrolledSyllabusYear;
    }

    public void setEnrolledSyllabusYear(SyllabusYear enrolledSyllabusYear) {
        this.enrolledSyllabusYear = enrolledSyllabusYear;
    }

    public Set<SkillDevelopmentCourses> getAppliedSkillDevelopmentCourses() {
        return appliedSkillDevelopmentCourses;
    }

    public void setAppliedSkillDevelopmentCourses(Set<SkillDevelopmentCourses> appliedSkillDevelopmentCourses) {
        this.appliedSkillDevelopmentCourses = appliedSkillDevelopmentCourses;
    }

    public Aadhaar getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(Aadhaar aadhaar) {
        this.aadhaar = aadhaar;
    }
}
