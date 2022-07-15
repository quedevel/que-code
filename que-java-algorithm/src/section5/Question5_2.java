package section5;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-02
 * 2. 괄호문자제거
 */
public class Question5_2 {
    public static void solution(String brackets){
        String result = "";
        char[] chars = brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            switch (c){
                case ')' :
                    while('('  !=  stack.peek()){
                        stack.pop();
                    }
                    stack.pop();
                    break;
                default:
                    stack.push(c);
            }
        }
        for (Character character : stack) {
            result += character;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        solution(brackets);
    }
}