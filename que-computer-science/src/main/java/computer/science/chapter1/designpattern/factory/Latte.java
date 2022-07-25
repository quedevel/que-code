package computer.science.chapter1.designpattern.factory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Latte extends Coffee{
    private int price;

    @Override
    public int getPrice() {
        return this.price;
    }
}
