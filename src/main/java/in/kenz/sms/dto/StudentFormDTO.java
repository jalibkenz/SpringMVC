package in.kenz.sms.dto;

import in.kenz.sms.model.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class StudentFormDTO {

    // ================= BASIC =================
    private Integer id;

    @NotBlank
    private String studentName;

    @NotNull
    @Min(1000000000L)
    @Max(9999999999L)
    private Long mobileNumber;

    // ================= SINGLE-VALUED =================
    @NotBlank
    private String clubName;

    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "Enter valid year")
    private String syllabusYear;

    @NotBlank
    private String uniRegNumber;

    @NotNull
    @Min(100000000000L)
    @Max(999999999999L)
    private Long aadhaarNumber;

    // ================= ONE-TO-MANY (SIMPLIFIED) =================
    private String buildingName;
    private String careTakerPersonName;

    // ================= MANY-TO-MANY =================
    @NotEmpty
    private List<Integer> courseIds = new ArrayList<>();

    private List<Integer> skillDevelopmentCourseIds = new ArrayList<>();

    // ================= CONSTRUCTORS =================
    public StudentFormDTO() {
    }

    public StudentFormDTO(String studentName,
                          Long mobileNumber,
                          String clubName,
                          String syllabusYear,
                          String uniRegNumber,
                          Long aadhaarNumber,
                          String buildingName,
                          String careTakerPersonName,
                          List<Integer> courseIds,
                          List<Integer> skillDevelopmentCourseIds) {

        this.studentName = studentName;
        this.mobileNumber = mobileNumber;
        this.clubName = clubName;
        this.syllabusYear = syllabusYear;
        this.uniRegNumber = uniRegNumber;
        this.aadhaarNumber = aadhaarNumber;
        this.buildingName = buildingName;
        this.careTakerPersonName = careTakerPersonName;
        this.courseIds = courseIds;
        this.skillDevelopmentCourseIds = skillDevelopmentCourseIds;
    }

    // ================= ENTITY → DTO MAPPER =================
    public static StudentFormDTO fromEntity(Student student) {

        StudentFormDTO dto = new StudentFormDTO();
        dto.setId(student.getId());
        // BASIC
        dto.setStudentName(student.getStudentName());
        dto.setMobileNumber(student.getMobileNumber());

        // CLUB
        if (student.getClub() != null) {
            dto.setClubName(student.getClub().getClubName());
        }

        // SYLLABUS YEAR
        if (student.getEnrolledSyllabusYear() != null) {
            dto.setSyllabusYear(
                    String.valueOf(
                            student.getEnrolledSyllabusYear().getSyllabusYear()
                    )
            );
        }

        // UNIVERSITY REGISTRATION
        if (student.getUniversityRegistrationNumber() != null) {
            dto.setUniRegNumber(
                    student.getUniversityRegistrationNumber().getUniRegNumber()
            );
        }

        // AADHAAR
        if (student.getAadhaar() != null) {
            dto.setAadhaarNumber(
                    student.getAadhaar().getAadhaarNumber()
            );
        }

        // ADDRESS (take first)
        if (student.getAddresses() != null && !student.getAddresses().isEmpty()) {
            dto.setBuildingName(
                    student.getAddresses().iterator().next().getBuildingName()
            );
        }

        // CARE TAKER (take first)
        if (student.getCareTakers() != null && !student.getCareTakers().isEmpty()) {
            dto.setCareTakerPersonName(
                    student.getCareTakers().iterator().next().getCareTakerPersonName()
            );
        }

        // COURSES
        if (student.getCourses() != null) {
            dto.setCourseIds(
                    student.getCourses()
                            .stream()
                            .map(Course::getId)
                            .toList()
            );
        }

        // SKILL DEVELOPMENT COURSES
        if (student.getAppliedSkillDevelopmentCourses() != null) {
            dto.setSkillDevelopmentCourseIds(
                    student.getAppliedSkillDevelopmentCourses()
                            .stream()
                            .map(SkillDevelopmentCourses::getId)
                            .toList()
            );
        }

        return dto;
    }

    // ================= GETTERS & SETTERS =================
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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getSyllabusYear() {
        return syllabusYear;
    }

    public void setSyllabusYear(String syllabusYear) {
        this.syllabusYear = syllabusYear;
    }

    public String getUniRegNumber() {
        return uniRegNumber;
    }

    public void setUniRegNumber(String uniRegNumber) {
        this.uniRegNumber = uniRegNumber;
    }

    public Long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(Long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCareTakerPersonName() {
        return careTakerPersonName;
    }

    public void setCareTakerPersonName(String careTakerPersonName) {
        this.careTakerPersonName = careTakerPersonName;
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public List<Integer> getSkillDevelopmentCourseIds() {
        return skillDevelopmentCourseIds;
    }

    public void setSkillDevelopmentCourseIds(List<Integer> skillDevelopmentCourseIds) {
        this.skillDevelopmentCourseIds = skillDevelopmentCourseIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentFormDTO{" +
                "studentName='" + studentName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", clubName='" + clubName + '\'' +
                ", syllabusYear='" + syllabusYear + '\'' +
                ", uniRegNumber='" + uniRegNumber + '\'' +
                ", aadhaarNumber=" + aadhaarNumber +
                ", buildingName='" + buildingName + '\'' +
                ", careTakerPersonName='" + careTakerPersonName + '\'' +
                ", courseIds=" + courseIds +
                ", skillDevelopmentCourseIds=" + skillDevelopmentCourseIds +
                '}';
    }
}