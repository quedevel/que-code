package study.quetdd.domain;

public class Dollar extends Money{

    Dollar(int amount){
        this.amount = amount;
    }

    Dollar times(int multiplier){
        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount;
    }

}
