package com.example.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @see <a href="https://www.baeldung.com/spring-boot-admin">https://www.baeldung.com/spring-boot-admin</a>
 */
@RestController
@SpringBootApplication
@EnableAdminServer
public class DemoApplication {

    @Autowired
    public DemoApplication(Fixture fixture) {
        if (!fixture.isDbInitialized()) fixture.initDb();
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
