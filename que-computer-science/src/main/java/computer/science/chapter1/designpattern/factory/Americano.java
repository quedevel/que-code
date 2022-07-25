package computer.science.chapter1.designpattern.factory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Americano extends Coffee{
    private int price;

    @Override
    public int getPrice() {
        return this.price;
    }
}
