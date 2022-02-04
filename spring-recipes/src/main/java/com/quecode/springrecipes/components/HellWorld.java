package com.quecode.springrecipes.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HellWorld {

    @PostConstruct
    public void sayHell(){
        System.out.println("Hell World, from Spring Boot 2!");
    }
}
/*

    @SpringBootApplication이 붙은 클래스를 최상위 패키지에 위치시킨다.
    그러면 자동으로 이 패키지와 하위 패키지에 정의된 모든 Annotation이 붙은 컴포넌트, 구성 클래스를 감지하게 된다.

    1. 애플리케이션이 부트스트랩되면서, 모든 @Component가 붙은 클래스를 감지하고 클래스패스에 있는 라이브러리를 감지하게 된다.

    2.스프링 부트는 위 클래스를 감지하고 빈 객체를 생성한다.

    3. @PostConstruct가 붙은 함수는 객체 생성 및 모든 의존성이 주입된 뒤 실행한다.

    4. 콘솔에 Hell World, from Spring Boot 2! 한 줄을 출력한다.

*/