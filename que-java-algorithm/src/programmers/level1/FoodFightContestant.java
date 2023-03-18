package programmers.level1;

public class FoodFightContestant {
    public static void main(String[] args) {
        FoodFightContestant foodFightContestant = new FoodFightContestant();
        System.out.println(foodFightContestant.solution(new int[]{1,3,4,6}));
        System.out.println(foodFightContestant.solution(new int[]{1,7,1,2}));
    }
    public String solution(int[] food) {
        String str = "";
        for (int i = 1; i < food.length; i++) {
            int n = food[i] / 2;
            if (n >= 1){
                for (int j = 0; j < n; j++) {
                    str += i;
                }
            }
        }
        return str + "0" + new StringBuffer(str).reverse();
    }
}
