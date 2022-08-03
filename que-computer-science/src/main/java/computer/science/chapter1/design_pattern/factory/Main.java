package computer.science.chapter1.design_pattern.factory;

public class Main {

    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano", 3000);
        System.out.println("latte = " + latte);
        System.out.println("americano = " + americano);
    }
}
