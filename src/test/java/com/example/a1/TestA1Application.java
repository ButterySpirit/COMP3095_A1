package com.example.a1;

import org.springframework.boot.SpringApplication;

public class TestA1Application {

    public static void main(String[] args) {
        SpringApplication.from(A1Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
