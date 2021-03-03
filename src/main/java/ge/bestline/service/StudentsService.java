package ge.bestline.service;

import ge.bestline.dao.StudentDAO;
import ge.bestline.model.ActivationFailedStudents;
import ge.bestline.model.ActivationJobConfig;
import ge.bestline.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentDAO studentDAO;

    public List<Students> getStudentsForActivation() {
        return studentDAO.getStudentsForActivation();
    }

    public ActivationJobConfig getJobActivationConfig() {
        return studentDAO.getJobActivationConfig();
    }

    @Transactional(rollbackFor = Throwable.class)
    public ActivationFailedStudents save(Students student, String resp) throws Exception {
        ActivationFailedStudents dbLog = new ActivationFailedStudents();
        dbLog.setFirstname(student.getFirstname());
        dbLog.setLastname(student.getLastname());
        dbLog.setPersNum(student.getPersNum());
        dbLog.setSpecialityId(student.getSpecialityId() + "");
        dbLog.setDavalianeba(student.getDavalianeba());
        dbLog.setBill(student.getBill());
        dbLog.setCurrency(student.getCurrency());
        dbLog.setRequestSent(1);
        dbLog.setStatus(resp.contains("Failed") ? "ERROR" : "OK");
        dbLog.setByJob(1);
        dbLog.setResponse(resp);
        dbLog = (ActivationFailedStudents) studentDAO.create(dbLog);
        return dbLog;
    }
}