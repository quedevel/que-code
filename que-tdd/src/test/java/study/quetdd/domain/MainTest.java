package study.quetdd.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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
        Money five = Money.dollar(5);
        assertThat(Money.dollar(10)).isEqualTo(five.times(2));
        assertThat(Money.dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
        assertThat(Money.franc(5).equals(Money.franc(6))).isFalse();

        // Franc Dollar 비교
        assertThat(Money.franc(5).equals(Money.dollar(5))).isFalse();
    }

    @Test
    void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertThat(Money.franc(10)).isEqualTo(five.times(2));
        assertThat(Money.franc(15)).isEqualTo(five.times(3));
    }

    @Test
    void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @Test
    void testDifferentClassEquality() {
        assertThat(new Money(10,"CHF")).isEqualTo(new Franc(10,"CHF"));
    }
}
