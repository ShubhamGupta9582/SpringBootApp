package com.demo.pkg.main;


import com.demo.pkg.entities.User;
import com.demo.pkg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.demo.pkg")
@EntityScan("com.demo.pkg.entities")
@EnableJpaRepositories("com.demo.pkg.repositories")
public class UserExecutor {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserExecutor.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName : beanNames){
                System.out.println(beanName);
            }
        };
    }
}
