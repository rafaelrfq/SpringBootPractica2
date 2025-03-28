package edu.pucmm.eict.alquiler;

import edu.pucmm.eict.alquiler.entities.security.User;
import edu.pucmm.eict.alquiler.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AlquilerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AlquilerApplication.class, args);

        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");

        User user = new User("rafael", "rafael", "Rafael Felipe", "ADMIN");
        if(userRepository.findAll().size() >= 1){
            System.out.println("User exists");
        } else { userRepository.save(user); }

    }
}
