package programmers.introduction.day15;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class UniqueCharFinder {
    public static void main(String[] args) {
        UniqueCharFinder uniqueCharFinder = new UniqueCharFinder();
        System.out.println(uniqueCharFinder.solution("abcabcadc"));
        System.out.println(uniqueCharFinder.solution("abdc"));
        System.out.println(uniqueCharFinder.solution("hello"));
    }
    public String solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = s.split("");
        for (String str : split) {
            if (map.containsKey(str)){
                int cnt = map.get(str) + 1;
                map.put(str, cnt);
            } else {
                map.put(str, 1);
            }
        }
        Set<String> set = new TreeSet<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1){
                set.add(key);
            }
        }
        return String.join("",set);
    }
}
