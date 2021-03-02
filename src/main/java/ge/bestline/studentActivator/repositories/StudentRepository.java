package ge.bestline.studentActivator.repositories;

import ge.bestline.studentActivator.entities.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Students, Integer> {
    // 10 - 10-calad moaqvs iseti studentebi romlebis davalianebac < wliuri/6
    // da mimdinare tveshi gaaqtiurebis statusi ar udris 'activated' da arc 5 jer metjer ar dafeilebula aqtivacia
    @Query(value = "SELECT s.* FROM students s WHERE s.edu_status = 1 AND s.davalianeba < bill / 6" +
            " AND s.pers_num NOT IN (SELECT a.pers_num FROM activation_failed_students a" +
            "    WHERE a.pers_num = s.pers_num AND IFNULL(a.response, '') LIKE '%activated%'" +
            "     AND YEAR(a.insert_date) = YEAR(CURDATE()) AND  MONTH(a.insert_date) = MONTH(CURDATE()) )" +
            "AND (SELECT COUNT(1) FROM activation_failed_students a2 WHERE a2.pers_num = s.pers_num " +
            "AND YEAR(a2.insert_date) = YEAR(CURDATE()) AND  MONTH(a2.insert_date) = MONTH(CURDATE()) ) < 6 LIMIT 10",
            nativeQuery = true)
    public List<Students> findAllForActivation();
}
