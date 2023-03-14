package programmers.introduction.day21;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.solution(new String[]{"p", "o", "s"}, new String[]{"sod", "eocd", "qixm", "adio", "soo"}));
        System.out.println(alienDictionary.solution(new String[]{"z", "d", "x"}, new String[]{"def", "dww", "dzx", "loveaw"}));
        System.out.println(alienDictionary.solution(new String[]{"s", "o", "m", "d"}, new String[]{"moos", "dzx", "smm", "sunmmo", "som"}));
    }
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int length = spell.length;

        for (int i = 0; i < dic.length; i++) {
            Map<String, Integer> convert = convert(dic[i]);
            for (int j = 0; j < spell.length; j++) {
                if (convert.containsKey(spell[j]) && convert.get(spell[j]) == 1){
                    answer++;
                }
            }
            if (answer == length){
                return 1;
            } else {
                answer = 0;
            }
        }
        return 2;
    }

    private static Map<String, Integer> convert(String s){
        Map<String, Integer> map = new HashMap<>();
        String[] split = s.split("");
        for (String s1 : split) {
            if (map.containsKey(s1)){
                int val = map.get(s1) + 1;
                map.put(s1, val);
            } else {
                map.put(s1, 1);
            }
        }
        return map;
    }
}
