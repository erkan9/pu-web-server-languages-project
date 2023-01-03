package org.erkamber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Erkann Kamber
 * @facultyNumber 1901261068
 */

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        {
        }
    }
}