package in.kenz.sms.dao.impl;

import in.kenz.sms.dao.SkillDevelopmentCourseDao;
import in.kenz.sms.model.SkillDevelopmentCourses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDevelopmentCourseDaoImpl implements SkillDevelopmentCourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SkillDevelopmentCourses> findAll() {
        return entityManager
                .createQuery(
                        "SELECT s FROM SkillDevelopmentCourses s",
                        SkillDevelopmentCourses.class
                )
                .getResultList();
    }

    @Override
    public List<SkillDevelopmentCourses> findByIds(List<Integer> ids) {
        return entityManager
                .createQuery(
                        "select s from SkillDevelopmentCourses s where s.id in :ids",
                        SkillDevelopmentCourses.class
                )
                .setParameter("ids", ids)
                .getResultList();
    }
}
