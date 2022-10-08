package com.example.jwtdemo;

import com.example.jwtdemo.entities.User;
import com.example.jwtdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class JwtDemoApplication {
    @Autowired
    UserRepository repository;
@PostConstruct
    public void initUsers(){
        List<User>users = Stream.of(

                new User(101, "user1", "user1", "user@user.lv"),
                new User(102, "user2","user2", "user2@user2.lv"),
        new User(103, "user3","user3", "user3@user3.lv")

        ).collect(Collectors.toList());
        repository.saveAll(users);
    }



    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

}
