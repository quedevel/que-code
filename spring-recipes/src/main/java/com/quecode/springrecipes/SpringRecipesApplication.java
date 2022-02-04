package com.quecode.springrecipes;

import com.quecode.springrecipes.calculator.Calculator;
import com.quecode.springrecipes.calculator.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/*

    @SpringBootApplication은 많은 Annotation의 집합이다.

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
	@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })

*/
@SpringBootApplication
public class SpringRecipesApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SpringRecipesApplication.class, args);
/*
        1-1. 생성된 Bean으로 계산하기
        var calculator = ctx.getBean(Calculator.class);
        calculator.calculate(11, 3, '+');
        calculator.calculate(11, 3, '*');
*/
    }
/*
    1. Calculator 객체의 팩토리 함수 만들기
    @Bean
    public Calculator calculator(Collection<Operation> operations){
        return new Calculator(operations);
    }
*/


/*
    2. Calculator 객체의 팩토리 함수를 만드렀지만 실제로는 필요 X
       Calculator 클래스에 @Component를 붙이면 스프링이 감지한다.

    @Bean
    public ApplicationRunner calculationRunner(Calculator calculator){
        return args -> {
            calculator.calculate(11, 3, '+');
            calculator.calculate(11, 3, '*');
        };
    }
*/

    // 3. 값을 property로 관리하기

    @Bean
    public ApplicationRunner calculationRunner(Calculator calculator,
           @Value("${lhs}") int lhs,
           @Value("${rhs}") int rhs,
           @Value("${op}") char op){
        return args -> calculator.calculate(lhs, rhs, op);
    }


}
