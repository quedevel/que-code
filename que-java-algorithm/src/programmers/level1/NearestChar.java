package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NearestChar {
    public static void main(String[] args) {
        NearestChar nearestChar = new NearestChar();
        System.out.println(Arrays.toString(nearestChar.solution("banana")));
        System.out.println(Arrays.toString(nearestChar.solution("foobar")));
    }
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] split = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])){
                answer[i] = i - map.get(split[i]);
                map.put(split[i], i);
            } else {
                answer[i] = -1;
                map.put(split[i], i);
            }
        }
        return answer;
    }
}
