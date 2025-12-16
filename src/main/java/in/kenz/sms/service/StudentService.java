package in.kenz.sms.service;

import in.kenz.sms.dto.StudentFormDTO;
import in.kenz.sms.model.Student;

public interface StudentService {
    void saveFromForm(StudentFormDTO studentFormDTO);

    void save(Student student);
}
