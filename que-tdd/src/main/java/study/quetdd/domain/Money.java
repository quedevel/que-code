package study.quetdd.domain;

public class Money implements Expression{

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    Money times(int multiplier){
        return new Money(amount*multiplier, currency);
    }

    String currency(){
        return currency;
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount &&
                currency().equals(money.currency());
    }

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    @Override
    public String toString() {
        return "amount=" + amount +
                ", currency='" + currency;
    }

    public Expression plus(Money addend) {
        return new Money(amount + addend.amount, currency);
    }
}
