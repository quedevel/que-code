package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class SecretCode {
    public static void main(String[] args) {
        SecretCode secretCode = new SecretCode();
        System.out.println(secretCode.solution("aukks","wbqd", 5));
    }

    // a b c d e f g h i j k l m n o p q r s t u v w x y z
    // a ~ z -> 97 ~ 122
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        Map<Integer, Character> skipMap = new HashMap<>();
        for (char c : skip.toCharArray()) {
            skipMap.put((int)c, c);
        }

        Map<Integer,Character> baseMap = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            if (!skipMap.containsKey(i)){
                baseMap.put(i, (char)i);
            }
        }

        for (char c : s.toCharArray()) {
            char currentChar = c;
            for (int i = 0; i < index; i++) {
                currentChar++;
                if (currentChar > 'z'){
                    currentChar -= 26;
                }
                while(!baseMap.containsKey((int)currentChar)){
                    currentChar++;
                }
            }
            answer.append(currentChar);
        }
        return answer.toString();
    }

}
