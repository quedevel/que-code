package org.quecode.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"org.quecode.backoffice.**","org.quecode.common.**"})
public class BackofficeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackofficeApplication.class);
    }
}
