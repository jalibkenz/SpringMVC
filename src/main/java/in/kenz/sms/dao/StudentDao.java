package in.kenz.sms.dao;

import in.kenz.sms.model.Student;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
    void deleteById(Integer id);
}
