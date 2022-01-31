package com.quecode.swagger.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @ApiModelProperty(value = "이름", example = "김동호", required = true)
    private String mbrNm;

    @ApiModelProperty(value = "나이", example = "33", required = true)
    private Integer age;
}
