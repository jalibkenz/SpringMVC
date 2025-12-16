package in.kenz.sms.controller;

import in.kenz.sms.dto.StudentFormDTO;
import in.kenz.sms.model.*;
import in.kenz.sms.service.CourseService;
import in.kenz.sms.service.SkillDevelopmentCourseService;
import in.kenz.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final SkillDevelopmentCourseService skillDevelopmentCourseService;

    public StudentController(StudentService studentService,
                             CourseService courseService,
                             SkillDevelopmentCourseService skillDevelopmentCourseService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.skillDevelopmentCourseService = skillDevelopmentCourseService;
    }

    // =========================================================
    // SHOW FORM
    // =========================================================
    @GetMapping("/form")
    public String showForm(Model model) {

        // DTO for form binding
        model.addAttribute("studentFormDTO", new StudentFormDTO());

        // Lists for checkbox rendering
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("skillDevelopmentCourses",
                skillDevelopmentCourseService.getAll());

        model.addAttribute("pageTitle", "Add Student");
        model.addAttribute("contentPage", "student-form.jsp");

        return "form";
    }

    // =========================================================
    // SAVE STUDENT
    // =========================================================
    @PostMapping("/formSave")
    public String saveStudent(
            @Valid @ModelAttribute("studentFormDTO") StudentFormDTO dto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {

            // Re-populate reference data
            model.addAttribute("courses", courseService.getAllCourses());
            model.addAttribute("skillDevelopmentCourses", skillDevelopmentCourseService.getAll());
            model.addAttribute("pageTitle", "Add Student");
            model.addAttribute("contentPage", "student-form.jsp");

            return "form";
        }

        studentService.saveFromForm(dto);
        return "redirect:/student/form";
    }


}