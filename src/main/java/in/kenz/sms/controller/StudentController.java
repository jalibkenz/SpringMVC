package in.kenz.sms.controller;

import in.kenz.sms.dto.StudentFormDTO;
import in.kenz.sms.model.Student;
import in.kenz.sms.service.CourseService;
import in.kenz.sms.service.SkillDevelopmentCourseService;
import in.kenz.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/student")
public class StudentController {

    // =========================================================
    // DEPENDENCIES
    // =========================================================
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
    // ADD STUDENT – SHOW FORM
    // URL  : GET /student/add
    // =========================================================
    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("studentFormDTO", new StudentFormDTO());
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("skillDevelopmentCourses", skillDevelopmentCourseService.getAll());

        model.addAttribute("pageTitle", "Add Student");
        model.addAttribute("contentPage", "navBarPage_add.jsp");

        return "navBarPage";
    }

    // =========================================================
    // ADD STUDENT – SAVE
    // URL  : POST /student/addSave
    // =========================================================
    @PostMapping("/addSave")
    public String saveStudent(
            @Valid @ModelAttribute("studentFormDTO") StudentFormDTO dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("courses", courseService.getAllCourses());
            model.addAttribute("skillDevelopmentCourses", skillDevelopmentCourseService.getAll());

            model.addAttribute("pageTitle", "Add Student");
            model.addAttribute("contentPage", "navBarPage_add.jsp");

            return "navBarPage";
        }

        studentService.saveFromForm(dto);
        return "redirect:/student/add";
    }

    // =========================================================
    // FIND STUDENT – SEARCH PAGE
    // URL  : GET /student/find
    // =========================================================
    @GetMapping("/find")
    public String showFind(Model model) {

        model.addAttribute("pageTitle", "Search Student");
        model.addAttribute("contentPage", "navBarPage_find.jsp");

        return "navBarPage";
    }

    // =========================================================
    // FIND STUDENT – VIEW BY ID
    // URL  : GET /student/find/{id}
    // =========================================================
    @GetMapping("/find/{id}")
    public String viewStudent(@PathVariable("id") Integer id, Model model) {

        Student student = studentService.findById(id);

        if (student == null) {
            model.addAttribute("errorMessage", "Student not found");
            model.addAttribute("contentPage", "navBarPage_find.jsp");
            return "navBarPage";
        }

        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "View Student");
        model.addAttribute("contentPage", "navBarPage_list.jsp");

        return "navBarPage";
    }

    // =========================================================
    // EDIT STUDENT – SEARCH PAGE
    // URL  : GET /student/edit
    // =========================================================
    @GetMapping("/edit")
    public String showEditSearch(Model model) {

        model.addAttribute("pageTitle", "Edit Student");
        model.addAttribute("contentPage", "navBarPage_edit_find.jsp");

        return "navBarPage";
    }

    // =========================================================
    // EDIT STUDENT – LOAD DATA
    // URL  : GET /student/edit/load?id=1
    // =========================================================
    @GetMapping("/edit/load")
    public String loadStudentForEdit(@RequestParam("id") Integer id, Model model) {

        Student student = studentService.findById(id);

        if (student == null) {
            model.addAttribute("errorMessage", "Student not found");
            return "error";
        }

        StudentFormDTO dto = StudentFormDTO.fromEntity(student);

        model.addAttribute("studentFormDTO", dto);
        model.addAttribute("studentId", id); // 🔴 IMPORTANT
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("skillDevelopmentCourses", skillDevelopmentCourseService.getAll());

        model.addAttribute("pageTitle", "Edit Student");
        model.addAttribute("contentPage", "navBarPage_edit_load.jsp");

        return "navBarPage";
    }

    // =========================================================
    // EDIT STUDENT – SAVE UPDATE
    // URL  : POST /student/edit/save/{id}
    // =========================================================
    @PostMapping("/edit/save/{id}")
    public String saveUpdatedStudent(
            @PathVariable("id") Integer id,
            @Valid @ModelAttribute("studentFormDTO") StudentFormDTO dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("studentId", id);
            model.addAttribute("courses", courseService.getAllCourses());
            model.addAttribute("skillDevelopmentCourses", skillDevelopmentCourseService.getAll());

            model.addAttribute("pageTitle", "Edit Student");
            model.addAttribute("contentPage", "navBarPage_edit_load.jsp");

            return "navBarPage";
        }

        studentService.updateFromForm(id, dto);
        return "redirect:/student/find";
    }


    // =========================================================
    // DELETE STUDENT – SEARCH PAGE
    // URL  : GET /student/delete
    // VIEW : navBarPage_delete_find.jsp
    // =========================================================
        @GetMapping("/delete")
        public String showDeleteSearch(Model model) {

            model.addAttribute("pageTitle", "Delete Student");
            model.addAttribute("contentPage", "navBarPage_delete_find.jsp");

            return "navBarPage";
        }


    // =========================================================
    // DELETE STUDENT – CONFIRM PAGE
    // URL  : GET /student/delete/confirm/{id}
    // =========================================================
    @GetMapping("/delete/confirm/{id}")
    public String confirmDelete(
            @PathVariable("id") Integer id,
            Model model) {

        Student student = studentService.findById(id);

        if (student == null) {
            model.addAttribute("errorMessage", "Student not found");
            model.addAttribute("contentPage", "navBarPage_delete_find.jsp");
            return "navBarPage";
        }

        model.addAttribute("student", student);
        model.addAttribute("pageTitle", "Confirm Delete");
        model.addAttribute("contentPage", "navBarPage_delete_confirm.jsp");

        return "navBarPage";
    }

    // =========================================================
    // DELETE STUDENT – EXECUTE
    // URL  : POST /student/delete/{id}
    // =========================================================
        @PostMapping("/delete/{id}")
        public String deleteStudent(
                @PathVariable("id") Integer id) {

            studentService.deleteById(id);
            return "redirect:/student/find";
        }
}