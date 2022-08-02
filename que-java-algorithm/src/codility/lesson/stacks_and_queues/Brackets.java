package codility.lesson.stacks_and_queues;

import java.util.Stack;

public class Brackets {
//    N is an integer within the range [0..200,000];
//    string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
    public int solution(String S) {
        if (S.length()%2 != 0) return 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            } else if (c == ')') {
                if (stack.isEmpty()) return 0;
                if ('(' == stack.peek()) stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty()) return 0;
                if ('{' == stack.peek()) stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty()) return 0;
                if ('[' == stack.peek()) stack.pop();
            }
        }
        return stack.isEmpty()? 1 : 0;
    }
    public static void main(String[] args) {
        Brackets b = new Brackets();
        System.out.println(b.solution(""));
    }
}
