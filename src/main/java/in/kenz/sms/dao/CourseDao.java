package in.kenz.sms.dao;

import in.kenz.sms.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAll();
    List<Course> findByIds(List<Integer> ids);

}
