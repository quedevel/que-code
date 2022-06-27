package study.quetdd.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MainTest {

    /**
     * 다중 통화를 지원하는 Money객체
     * $5 + 10CHF = $10 (환율이 2:1일 경우)
     * $5 * 2 = $10
     *
     * amount를 private으로 만들기
     * Dollar 부작용?
     * Money 반올림?
     */
    @Test
    void testMultiplication() {
        //given
        Dollar five = new Dollar(5);

        //when
        five.times(2);

        //then
        assertThat(10).isEqualTo(five.amount);
    }
}
