package programmers.introduction.day3;

import java.util.HashMap;
import java.util.Map;

public class ModeFinder {
    public static void main(String[] args) {
        ModeFinder modeFinder = new ModeFinder();
        System.out.println(modeFinder.solution(new int[]{1, 2, 3, 3, 3, 4}));
        System.out.println(modeFinder.solution(new int[]{1,1,2,2}));
        System.out.println(modeFinder.solution(new int[]{1}));
    }
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if(map.containsKey(i)){
                int val = map.get(i) + 1;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }

        int answer = 0;
        int max = 0;
        for (int key : map.keySet()) {
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        int count = 0;
        for (int key :map.keySet()){
            if(map.get(key) == max) count++;
        }
        return count > 1? -1 : answer;
    }
}
