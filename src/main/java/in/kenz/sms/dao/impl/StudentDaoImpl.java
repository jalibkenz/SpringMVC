package in.kenz.sms.dao.impl;

import in.kenz.sms.dao.StudentDao;
import in.kenz.sms.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Student student) {
        entityManager.persist(student);
        System.out.println("SAVED");

    }
}
