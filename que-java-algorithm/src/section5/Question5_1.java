package section5;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-01
 * 1. 올바른 괄호
 */
public class Question5_1 {
    public static String solution(String brackets){
        char[] chars = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c){
                case ')':
                    if (stack.isEmpty()) return "NO";
                    if ('(' == stack.peek()) stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty()) return "NO";
                    if ('{' == stack.peek()) stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty()) return "NO";
                    if ('[' == stack.peek()) stack.pop();
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty()? "YES" : "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        System.out.println(solution(brackets));
    }
}