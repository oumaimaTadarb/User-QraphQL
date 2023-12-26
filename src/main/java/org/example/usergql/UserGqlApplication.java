package org.example.usergql;

import org.example.usergql.dao.entities.User;
import org.example.usergql.dao.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserGqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserGqlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository){
        return args -> {
            userRepository.save(User.builder().name("oum").
                    dateNaissance("05/07/2001").password("oum").
                    email("oum@gmail.com").
                    build());
            userRepository.save(User.builder().name("mayma").
                    dateNaissance("21/12/2001").
                    password("mayma").
                    email("mayma@gmail.com").
                    build());
            userRepository.save(User.builder().name("noha").
                    dateNaissance("30/06/2001").
                    password("noha").
                    email("noha@gmail.com").
                    build());
            userRepository.save(User.builder().name("Mehdi").
                    dateNaissance("21/10/2001").
                    password("Mehdi").
                    email("mehdi@gmail.com").
                    build());

        };
    }
}
