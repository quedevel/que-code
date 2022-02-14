package com.quecode.springrecipes.hell;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class HellWorldController {

    private final TaskExecutor taskExecutor;

    public HellWorldController(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    // 스프링 MVC 비동기

    @GetMapping("/")
    public CompletableFuture<String> hell(){
        return CompletableFuture.supplyAsync(() -> {
            randomDelay();
            return "Hell World, from Spring Boot 2!";
        }, taskExecutor);
    }

    private void randomDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
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

