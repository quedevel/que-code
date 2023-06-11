package com.spring.swagger.controller;

import com.spring.swagger.dto.SwaggerDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.spring.swagger.controller
 * fileName       : SwaggerApiController
 * author         : kimdongho
 * date           : 2023/06/10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/06/10        kimdongho       최초 생성
 */

@RestController
@RequestMapping("/swagger/api")
@Tag(name = "swagger controller api", description = "Swagger 예제를 위한 샘플 API")
public class SwaggerApiController {

  @GetMapping
  @Operation(summary = "mapping summary", description = "mapping description")
  public SwaggerDto swaggerApi(SwaggerDto swaggerDto){
    swaggerDto.setTitle("dto title");
    swaggerDto.setDescription("dto description");
    swaggerDto.setVersion("dto v1");
    return swaggerDto;
  }

}
