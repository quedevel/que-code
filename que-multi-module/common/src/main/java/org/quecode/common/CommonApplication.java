package org.quecode.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"org.quecode.common.util","org.quecode.common.**.repository","org.quecode.common.**.service"})
@SpringBootApplication
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
