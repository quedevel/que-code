package study.quetdd.domain;

public class Money {

    protected int amount;

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount &&
                getClass().equals(money.getClass());
    }
}
