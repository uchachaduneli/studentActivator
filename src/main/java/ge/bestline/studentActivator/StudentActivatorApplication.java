package ge.bestline.studentActivator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentActivatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentActivatorApplication.class, args);
    }

}
