package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnfinishedKeyboard {
    public static void main(String[] args) {
        UnfinishedKeyboard unfinishedKeyboard = new UnfinishedKeyboard();
        System.out.println(Arrays.toString(unfinishedKeyboard.solution(new String[]{"ABACD","BCEFD"},new String[]{"ABCD","AABB"})));
        System.out.println(Arrays.toString(unfinishedKeyboard.solution(new String[]{"AA"},new String[]{"B"})));
        System.out.println(Arrays.toString(unfinishedKeyboard.solution(new String[]{"AGZ","BSSS"},new String[]{"ASA","BGZ"})));
    }
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String[] s = keymap[i].split("");
            int length = s.length;
            for (int j = 0; j < length; j++) {
                if (map.containsKey(s[j])){
                    int savedIndex = map.get(s[j]);
                    if (savedIndex > (j+1)){
                        map.put(s[j], j+1);
                    }
                } else {
                    map.put(s[j], j+1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = -1;
            String[] split = targets[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (map.containsKey(split[j])){
                    sum += map.get(split[j]);
                } else {
                    sum = -1;
                    break;
                }
            }
            if (sum != -1) sum += 1;
            answer[i] = sum;
        }
        return answer;
    }
}
