package programmers.level1;

import java.util.Stack;

public class BurgerMaker {
    public static void main(String[] args) {
        BurgerMaker burgerMaker = new BurgerMaker();
        System.out.println(burgerMaker.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(burgerMaker.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
    // 빵 – 야채 – 고기 - 빵
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int num : ingredient) {
            int vegetable = -1;
            int bread = -1;
            if (!stack.isEmpty() && stack.peek() == 3 && num == 1) {
                int meat = stack.pop();
                int cnt = 0;
                if (!stack.empty() && stack.peek() == 2){
                    vegetable = stack.pop();
                    cnt++;
                }
                if (!stack.empty() && stack.peek() == 1){
                    bread = stack.pop();
                    cnt++;
                }
                if (cnt == 2){
                    answer ++;
                } else {
                    if (bread != -1){
                        stack.add(bread);
                        bread = -1;
                    }
                    if (vegetable != -1){
                        stack.add(vegetable);
                        vegetable = -1;
                    }
                    stack.add(meat);
                    stack.add(num);
                }
            } else {
                stack.push(num);
            }
        }
        return answer;
    }
}
