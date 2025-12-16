package in.kenz.sms.dao.impl;

import in.kenz.sms.dao.StudentDao;
import in.kenz.sms.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Student student) {
        entityManager.persist(student);
        System.out.println("SAVED");

    }

    @Override
    public Student findById(Integer id) {

        List<Student> result = entityManager.createQuery("""
        select distinct s from Student s
        left join fetch s.courses
        left join fetch s.appliedSkillDevelopmentCourses
        left join fetch s.addresses
        left join fetch s.careTakers
        left join fetch s.club
        left join fetch s.enrolledSyllabusYear
        left join fetch s.aadhaar
        where s.id = :id
        """, Student.class)
                .setParameter("id", id)
                .getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
