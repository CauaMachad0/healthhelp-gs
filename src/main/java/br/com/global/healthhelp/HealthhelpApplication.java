package br.com.global.healthhelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class HealthhelpApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthhelpApplication.class, args);
    }
}
