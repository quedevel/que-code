# spring swagger3

## 설정 방법

### dependencies 추가
```
implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'
// https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui
implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '3.0.0'
```

### SwaggerConfig 설정
```java
@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        String description = "Qua Swagger API TEST";
        return new ApiInfoBuilder()
                .title("Qua Swagger API")
                .description(description)
                .version("1.0")
                .build();
    }
}
```

### RestController
```java
@Api(tags = {"Swagger Controller"})
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/hello")
    public String hell(){
        return "hell world...";
    }
}
```