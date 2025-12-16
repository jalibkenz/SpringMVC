package in.kenz.sms.service.impl;

import in.kenz.sms.dao.SkillDevelopmentCourseDao;
import in.kenz.sms.model.SkillDevelopmentCourses;
import in.kenz.sms.service.SkillDevelopmentCourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkillDevelopmentCourseServiceImpl
        implements SkillDevelopmentCourseService {

    private final SkillDevelopmentCourseDao skillDevelopmentCourseDao;

    public SkillDevelopmentCourseServiceImpl(SkillDevelopmentCourseDao skillDevelopmentCourseDao) {
        this.skillDevelopmentCourseDao = skillDevelopmentCourseDao;
    }


    @Override
    public List<SkillDevelopmentCourses> getAll() {
        return skillDevelopmentCourseDao.findAll();
    }

    @Override
    public Set<SkillDevelopmentCourses> findByIds(List<Integer> skillDevelopmentCourseIds) {
        return new HashSet<>(
                skillDevelopmentCourseDao.findByIds(skillDevelopmentCourseIds)
        );
    }
}