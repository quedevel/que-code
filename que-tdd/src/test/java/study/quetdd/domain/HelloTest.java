package study.quetdd.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
class HelloTest {

    @Test
    @DisplayName("롬복 테스트")
    void lombokTest() {
        //given
        String param = "hello";

        //when
        Hello hello = new Hello(param);

        //then
        assertThat(param).isEqualTo(hello.getName());
    }
}