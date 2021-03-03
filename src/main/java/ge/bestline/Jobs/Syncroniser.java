package ge.bestline.Jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import ge.bestline.model.Students;
import ge.bestline.service.StudentsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Syncroniser {

    Logger logger = Logger.getLogger(Syncroniser.class);

    @Autowired
    StudentsService studentsService;

    @Scheduled(fixedRate = 30000)
    public void runTask() {

        final String uri = "https://goni.ciu.edu.ge/ge/service/activateStudent/";

        if (studentsService.getJobActivationConfig().getEnabled() == 1) {
            logger.debug("************ Student Status Syncronizer Started ************");
            for (Students student : studentsService.getStudentsForActivation()) {
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
                    try {
                        studentsService.save(student, resp);
                    } catch (Exception e) {
                        logger.error(e);
                    }
                }
            }
            logger.info("************ Student Status Activation Finished ************");
        }

    }
}
