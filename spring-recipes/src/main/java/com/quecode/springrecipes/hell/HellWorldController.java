package com.quecode.springrecipes.hell;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellWorldController {

    @GetMapping("/")
    public String hell(){
        return "Hell World, from Spring Boot 2!";
    }
}
/*
    명령 프롬프트

    C:\Users\kdh90>curl -v http://localhost:8080
    *   Trying 127.0.0.1:8080...
    * Connected to localhost (127.0.0.1) port 8080 (#0)
    > GET / HTTP/1.1
    > Host: localhost:8080
    > User-Agent: curl/7.79.1

    < HTTP/1.1 200
    < Content-Type: text/plain;charset=UTF-8
    < Content-Length: 31
    < Date: Fri, 04 Feb 2022 12:59:44 GMT
    <
    Hell World, from Spring Boot 2!* Connection #0 to host localhost left intact

    C:\Users\kdh90>


*/

