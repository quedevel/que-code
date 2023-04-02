package programmers.level2;

import java.util.Stack;

public class BracketRotator {
    public static void main(String[] args) {
        BracketRotator bracketRotator = new BracketRotator();
        System.out.println(bracketRotator.solution("[](){}"));
        System.out.println(bracketRotator.solution("}]()[{"));
        System.out.println(bracketRotator.solution("[)(]"));
        System.out.println(bracketRotator.solution("}}}"));
    }
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isExactBracket(s)){
                answer++;
            }
            s = rotateLeft(s);
        }
        return answer;
    }
    private static String rotateLeft(String s){
        char first = s.charAt(0);
        return s.substring(1)+first;
    }
    private static boolean isExactBracket(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case '[' :
                case '{' :
                case '(' : {
                    stack.push(c);
                    break;
                }
                case ']' : {
                    if (stack.empty() || stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                    break;
                }
                case '}' : {
                    if (stack.empty() || stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                    break;
                }
                case ')' : {
                    if (stack.empty() || stack.peek() != '('){
                        return false;
                    }
                    stack.pop();
                    break;
                }
            }
        }
        return stack.empty();
    }
}
