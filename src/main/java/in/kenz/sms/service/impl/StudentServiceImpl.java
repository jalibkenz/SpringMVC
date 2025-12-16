package in.kenz.sms.service.impl;

import in.kenz.sms.dao.CourseDao;
import in.kenz.sms.dao.SkillDevelopmentCourseDao;
import in.kenz.sms.dao.StudentDao;
import in.kenz.sms.dto.StudentFormDTO;
import in.kenz.sms.model.*;
import in.kenz.sms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final SkillDevelopmentCourseDao skillCourseDao;

    public StudentServiceImpl(StudentDao studentDao,
                              CourseDao courseDao,
                              SkillDevelopmentCourseDao skillCourseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.skillCourseDao = skillCourseDao;
    }

    // =========================================================
    // SAVE STUDENT (WRITE TRANSACTION)
    // =========================================================
    @Override
    @Transactional
    public void saveFromForm(StudentFormDTO studentFormDTO) {

        Student student = new Student();

        // ===== BASIC =====
        student.setStudentName(studentFormDTO.getStudentName());
        student.setMobileNumber(studentFormDTO.getMobileNumber());

        // ===== CLUB =====
        Club club = new Club();
        club.setClubName(studentFormDTO.getClubName());
        student.setClub(club);

        // ===== SYLLABUS YEAR =====
        SyllabusYear syllabusYear = new SyllabusYear();
        syllabusYear.setSyllabusYear(studentFormDTO.getSyllabusYear());
        student.setEnrolledSyllabusYear(syllabusYear);

        // ===== UNIVERSITY REG =====
        UniversityRegistrationNumber urn = new UniversityRegistrationNumber();
        urn.setUniRegNumber(studentFormDTO.getUniRegNumber());
        student.setUniversityRegistrationNumber(urn);

        // ===== AADHAAR =====
        Aadhaar aadhaar = new Aadhaar();
        aadhaar.setAadhaarNumber(studentFormDTO.getAadhaarNumber());
        student.setAadhaar(aadhaar);

        // ===== ADDRESS =====
        Address address = new Address();
        address.setBuildingName(studentFormDTO.getBuildingName());
        student.getAddresses().add(address);

        // ===== CARE TAKER =====
        CareTaker careTaker = new CareTaker();
        careTaker.setCareTakerPersonName(studentFormDTO.getCareTakerPersonName());
        careTaker.setCareTakerOfTheStudent(student);
        student.getCareTakers().add(careTaker);

        // ===== COURSES (ManyToMany) =====
        Set<Course> courses =
                new HashSet<>(courseDao.findByIds(studentFormDTO.getCourseIds()));
        student.setCourses(courses);

        // ===== SKILL DEVELOPMENT COURSES =====
        Set<SkillDevelopmentCourses> skillCourses =
                new HashSet<>(skillCourseDao.findByIds(
                        studentFormDTO.getSkillDevelopmentCourseIds()));
        student.setAppliedSkillDevelopmentCourses(skillCourses);

        // ===== SAVE ROOT =====
        studentDao.save(student);
    }


    // =========================================================
    // FIND STUDENT (READ-ONLY)
    // =========================================================
    @Override
    @Transactional(readOnly = true)
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }





    // =========================================================
    // UPDATE STUDENT
    // =========================================================

    @Override
    @Transactional
    public void updateFromForm(Integer id, StudentFormDTO dto) {

        Student student = studentDao.findById(id);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        student.setStudentName(dto.getStudentName());
        student.setMobileNumber(dto.getMobileNumber());
        student.getClub().setClubName(dto.getClubName());
        student.getEnrolledSyllabusYear().setSyllabusYear(dto.getSyllabusYear());
        student.getUniversityRegistrationNumber()
                .setUniRegNumber(dto.getUniRegNumber());
        student.getAadhaar().setAadhaarNumber(dto.getAadhaarNumber());

        student.getAddresses().clear();
        Address address = new Address();
        address.setBuildingName(dto.getBuildingName());
        student.getAddresses().add(address);

        student.getCareTakers().clear();
        CareTaker careTaker = new CareTaker();
        careTaker.setCareTakerPersonName(dto.getCareTakerPersonName());
        student.getCareTakers().add(careTaker);

        student.setCourses(
                new HashSet<>(courseDao.findByIds(dto.getCourseIds()))
        );

        student.setAppliedSkillDevelopmentCourses(
                new HashSet<>(skillCourseDao.findByIds(
                        dto.getSkillDevelopmentCourseIds()))
        );
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }
}