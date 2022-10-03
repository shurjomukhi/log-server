package com.shurjomukhi.logserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.AdminServerHazelcastAutoConfiguration;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * @author Mahmudul Hasan Rana
 * @since 2022-10-03
 */
@SpringBootApplication(exclude = AdminServerHazelcastAutoConfiguration.class)
@EnableAdminServer
public class LogServerApplication {
	
	public static void main(String... args) {
        SpringApplication.run(LogServerApplication.class, args);
    }

}
