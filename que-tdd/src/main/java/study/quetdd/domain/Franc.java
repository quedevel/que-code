package study.quetdd.domain;

public class Franc extends Money{

    Franc(int amount){
        this.amount = amount;
    }

    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount;
    }

}
