package in.kenz.sms.service;

import in.kenz.sms.model.SkillDevelopmentCourses;

import java.util.List;
import java.util.Set;

public interface SkillDevelopmentCourseService {
    List<SkillDevelopmentCourses> getAll();
    Set<SkillDevelopmentCourses> findByIds(List<Integer> skillDevelopmentCourseIds);
}