package programmers.introduction.day24;

public class ChickenCoupon {
    public static void main(String[] args) {
        ChickenCoupon chickenCoupon = new ChickenCoupon();
        System.out.println(chickenCoupon.solution(100));
        System.out.println(chickenCoupon.solution(1081));
    }
    public int solution(int chicken) {
        int coupon = chicken;
        int answer = 0;
        while(coupon >= 10){
            answer += coupon/10;
            coupon = coupon/10 + coupon%10;
        }
        return answer;
    }
}
