package in.kenz.sms.service;

import in.kenz.sms.dto.StudentFormDTO;
import in.kenz.sms.model.Student;
import jakarta.validation.Valid;

public interface StudentService {
    void saveFromForm(StudentFormDTO studentFormDTO);
    Student findById(Integer id);
    void updateFromForm(Integer id, @Valid StudentFormDTO dto);
    void deleteById(Integer id);
}
