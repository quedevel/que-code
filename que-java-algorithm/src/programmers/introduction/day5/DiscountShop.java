package programmers.introduction.day5;

public class DiscountShop {
    public static void main(String[] args) {
        DiscountShop discountShop = new DiscountShop();
        System.out.println(discountShop.solution(150000));
        System.out.println(discountShop.solution(580000));
    }
    public int solution(int price) {
        if (price >= 500000) {
            return (int)(price * 0.8);
        } else if (price >= 300000) {
            return (int)(price * 0.9);
        } else if (price >= 100000) {
            return (int)(price * 0.95);
        } else {
            return price;
        }
    }
}
