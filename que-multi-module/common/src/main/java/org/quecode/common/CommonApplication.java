package org.quecode.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.quecode.common.**.service","org.quecode.common.util"})
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
