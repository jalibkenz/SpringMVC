package in.kenz.sms.service;

import in.kenz.sms.model.Course;

import java.util.List;
import java.util.Set;

public interface CourseService {
    List<Course> getAllCourses();

    Set<Course> findByIds(List<Integer> courseIds);
}
