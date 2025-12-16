package in.kenz.sms.dao;

import in.kenz.sms.model.SkillDevelopmentCourses;

import java.util.List;

public interface SkillDevelopmentCourseDao {
    List<SkillDevelopmentCourses> findAll();
    List<SkillDevelopmentCourses> findByIds(List<Integer> ids);
}
