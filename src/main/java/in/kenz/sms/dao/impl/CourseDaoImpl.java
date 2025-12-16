package in.kenz.sms.dao.impl;

import in.kenz.sms.dao.CourseDao;
import in.kenz.sms.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Course> getAll() {
        return entityManager
                .createQuery("SELECT c FROM Course c", Course.class)
                .getResultList();
    }

    @Override
    public List<Course> findByIds(List<Integer> ids) {
        return entityManager
                .createQuery(
                        "from Course c where c.id in :ids", Course.class)
                .setParameter("ids", ids)
                .getResultList();
    }
}
