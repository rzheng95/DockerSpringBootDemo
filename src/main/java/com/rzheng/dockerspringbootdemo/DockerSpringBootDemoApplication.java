package com.rzheng.dockerspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerSpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerSpringBootDemoApplication.class, args);
    }


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World! Richard Zheng!!! Test";
    }
}
