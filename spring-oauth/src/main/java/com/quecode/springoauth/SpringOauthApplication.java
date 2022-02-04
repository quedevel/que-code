package com.quecode.springoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class SpringOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOauthApplication.class, args);
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Helllo!");
    }
/*
        PS C:\Users\kdh90\Desktop\que-code\spring-oauth> curl -v http://localhost:8080/message
        자세한 정보 표시: GET http://localhost:8080/message with 0-byte payload
        자세한 정보 표시: received 7-byte response of content type text/plain;charset=UTF-8


        StatusCode        : 200
        StatusDescription :
        Content           : Helllo!
        RawContent        : HTTP/1.1 200
                            Keep-Alive: timeout=60
                            Connection: keep-alive
                            Content-Length: 7
                            Content-Type: text/plain;charset=UTF-8
                            Date: Fri, 04 Feb 2022 13:27:18 GMT

                            Helllo!
        Forms             : {}
        Headers           : {[Keep-Alive, timeout=60], [Connection, keep-alive], [Content-Length, 7], [Content-Type, text/plain;charset=UTF-8]...}
        Images            : {}
        InputFields       : {}
        Links             : {}
        ParsedHtml        : System.__ComObject
        RawContentLength  : 7



        PS C:\Users\kdh90\Desktop\que-code\spring-oauth>
*/

}
