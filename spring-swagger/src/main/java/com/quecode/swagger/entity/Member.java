package com.quecode.swagger.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @ApiModelProperty(value = "이름", example = "김동호", required = true)
    private String mbrNm;

    @ApiModelProperty(value = "나이", example = "33", required = true)
    private Integer age;

    // not working
    @ApiModelProperty(value = "stringValue", example = "{key, value}", required = true)
    private Map<String, String> stringMap;

    @ApiModelProperty(value = "objectValue", example = "{key, value}", required = true)
    private Map<String, Object> objectMap;

    public Member(String mbrNm, Integer age){
        this.mbrNm = mbrNm;
        this.age = age;
    }
}
