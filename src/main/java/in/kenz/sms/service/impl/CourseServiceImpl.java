package in.kenz.sms.service.impl;

import in.kenz.sms.dao.CourseDao;
import in.kenz.sms.model.Course;
import in.kenz.sms.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {


    private final CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {

        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    @Override
    public Set<Course> findByIds(List<Integer> courseIds) {
        return new HashSet<>(courseDao.findByIds(courseIds));
    }
}
