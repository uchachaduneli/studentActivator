package ge.bestline.studentActivator.jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.bestline.studentActivator.entities.ActivationFailedStudents;
import ge.bestline.studentActivator.entities.ActivationJobConfig;
import ge.bestline.studentActivator.entities.Students;
import ge.bestline.studentActivator.repositories.ActivationFaildStudentsRepository;
import ge.bestline.studentActivator.repositories.ActivationJobConfigRepository;
import ge.bestline.studentActivator.repositories.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentActivator {

    private static final Logger logger = LogManager.getLogger(StudentActivator.class);

    @Autowired
    ActivationJobConfigRepository configRepository;

    @Autowired
    ActivationFaildStudentsRepository activationFaildStudentsRepository;

    @Autowired
    StudentRepository studentRepository;

    @Scheduled(fixedRate = 100000)
    public void runTask() {
        final String uri = "https://goni.ciu.edu.ge/ge/service/activateStudent/";
        if (((ActivationJobConfig) configRepository.findById(1).get()).getEnabled() == 1) {
            logger.debug("************ Student Status Syncronizer Started ************");
            for (Students student : studentRepository.findAllForActivation()) {
                String resp = "";
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    ObjectMapper mapper = new ObjectMapper();
                    resp = restTemplate.getForObject(uri + "/" + student.getPersNum() + "/" + student.getSpecialityId(), String.class);
                    logger.info(" Response " + resp);
                } catch (Exception e) {
                    logger.error("************ Student Status Activation Failed *************", e);
                    resp = "Activation Failed -  " + e.getMessage();
                } finally {
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
                    activationFaildStudentsRepository.save(dbLog);
                }
            }
            logger.info("************ Student Status Activation Finished ************");
        }
    }
}
