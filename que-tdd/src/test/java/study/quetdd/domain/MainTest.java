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
        Dollar five = new Dollar(5);
        assertThat(new Dollar(10)).isEqualTo(five.times(2));
        assertThat(new Dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    void testEquality() {
        assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
    }

    @Test
    void testFrancMultiplication() {
        Dollar five = new Dollar(5);
        assertThat(new Dollar(10)).isEqualTo(five.times(2));
        assertThat(new Dollar(15)).isEqualTo(five.times(3));
    }
}
