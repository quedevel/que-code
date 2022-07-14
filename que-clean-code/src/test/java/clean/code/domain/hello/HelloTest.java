package clean.code.domain.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloTest {

    @Test
    void hello(){
        //given
        Long id = 1L;
        String message = "Hello World";
        Hello hello = new Hello(id, message);

        //when
        Long expectedId = hello.getId();
        String expectedMessage = hello.getMessage();

        //then
        assertThat(id).isEqualTo(expectedId);
        assertThat(message).isEqualTo(expectedMessage);
    }

}