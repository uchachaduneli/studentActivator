package ge.bestline.dao;


import ge.bestline.model.ActivationJobConfig;
import ge.bestline.model.Students;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ME.
 */

@Repository
public class StudentDAO extends AbstractDAO {

    @PersistenceContext(unitName = "emailer")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Students> getStudentsForActivation() {
        String qr = "SELECT s.* FROM students s WHERE s.edu_status = 1 AND s.davalianeba < bill / 6" +
                " AND s.pers_num NOT IN (SELECT a.pers_num FROM activation_failed_students a" +
                "    WHERE a.pers_num = s.pers_num AND IFNULL(a.response, '') LIKE '%activated%'" +
                "     AND YEAR(a.insert_date) = YEAR(CURDATE()) AND  MONTH(a.insert_date) = MONTH(CURDATE()) )" +
                "AND (SELECT COUNT(1) FROM activation_failed_students a2 WHERE a2.pers_num = s.pers_num " +
                "AND YEAR(a2.insert_date) = YEAR(CURDATE()) AND  MONTH(a2.insert_date) = MONTH(CURDATE()) ) < 6 LIMIT 10";

        return entityManager.createNativeQuery(qr, Students.class).getResultList();
    }

    public ActivationJobConfig getJobActivationConfig() {
        String qr = "SELECT * FROM activation_job_config";
        return (ActivationJobConfig) entityManager.createNativeQuery(qr, ActivationJobConfig.class).getSingleResult();
    }


}
