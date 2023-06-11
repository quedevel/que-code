package com.spring.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : com.spring.swagger.config
 * fileName       : SwaggerConfig
 * author         : kimdongho
 * date           : 2023/06/10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/06/10        kimdongho       최초 생성
 */
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI(){
    return new OpenAPI().info(new Info()
        .title("please enter title...")
        .description("please enter description..."));

  }
}
