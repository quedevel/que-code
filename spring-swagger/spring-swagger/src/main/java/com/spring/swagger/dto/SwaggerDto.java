package com.spring.swagger.dto;

import lombok.Data;

/**
 * packageName    : com.spring.swagger.dto
 * fileName       : SwaggerDto
 * author         : kimdongho
 * date           : 2023/06/10
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/06/10        kimdongho       최초 생성
 */
@Data
public class SwaggerDto {
  private String title;
  private String description;
  private String version;
}
