package programmers.level2;

import java.util.Stack;

public class RemovePair {
    public static void main(String[] args) {
        RemovePair removePair = new RemovePair();
        System.out.println(removePair.solution("baabaa"));
        System.out.println(removePair.solution("cdcd"));
    }
    // 97 <= x <= 122
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()){
                stack.push(c);
            } else {
                if (stack.peek() == c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.empty()? 1 : 0;
    }
}
