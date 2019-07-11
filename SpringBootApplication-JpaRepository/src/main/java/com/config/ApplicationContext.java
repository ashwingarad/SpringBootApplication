package com.config;

import com.dao.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com"})
@EntityScan(basePackages = "com.model")
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class ApplicationContext {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);

        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
    }
}
