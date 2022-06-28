package study.quetdd.domain;

public abstract class Money {

    protected int amount;

    abstract Money times(int multiplier);

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount &&
                getClass().equals(money.getClass());
    }

    static Money dollar(int amount){
        return new Dollar(amount);
    }

    static Money franc(int amount){
        return new Franc(amount);
    }
}