package org.example.boomvim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BoomVimApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoomVimApplication.class, args);
    }
}
