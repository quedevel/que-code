package programmers.level2;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.solution("()()"));
        System.out.println(validParentheses.solution("(())()"));
        System.out.println(validParentheses.solution(")()("));
        System.out.println(validParentheses.solution("(()("));
    }
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(c); break;
                case ')': {
                    if (stack.empty()){
                        return false;
                    }
                    if (stack.peek() == '('){
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }
}
