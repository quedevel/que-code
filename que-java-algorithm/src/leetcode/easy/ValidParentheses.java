package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        String[] sArr = s.split("");
        Stack<String> stack = new Stack<>();
        int cnt = 0;
        for (String s1 : sArr) {
            switch (s1){
                case ")":
                    if (stack.isEmpty()) return false;
                    if("(".equals(stack.peek())) stack.pop();
                    break;
                case "}":
                    if (stack.isEmpty()) return false;
                    if("{".equals(stack.peek())) stack.pop();
                    break;
                case "]":
                    if (stack.isEmpty()) return false;
                    if("[".equals(stack.peek())) stack.pop();
                    break;
                default:
                    stack.push(s1);
                    cnt++;
                    break;
            }
        }
        return stack.isEmpty() && s.length()/2 == cnt;
    }

    public static void main(String[] args) {
        String str = "([}]";
        System.out.println(isValid(str));
    }
}
