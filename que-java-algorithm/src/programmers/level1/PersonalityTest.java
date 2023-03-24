package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTest {
    public static void main(String[] args) {
        PersonalityTest personalityTest = new PersonalityTest();
        System.out.println(personalityTest.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(personalityTest.solution(new String[]{"TR", "RT", "TR"}, new int[]{7,1,3}));
    }
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> personalityMap = new HashMap<>();
        String[] personalities = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for (String personality : personalities) {
            personalityMap.put(personality, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            int score = Math.abs(choices[i]-4);
            String[] split = survey[i].split("");
            putPersonality(personalityMap, split, choices[i] > 4? 1 : 0, score);
        }

        String answer = "";
        int r = personalityMap.get("R");
        int t = personalityMap.get("T");
        answer += r < t? "T" : "R";
        int c = personalityMap.get("C");
        int f = personalityMap.get("F");
        answer += c < f? "F" : "C";
        int j = personalityMap.get("J");
        int m = personalityMap.get("M");
        answer += j < m? "M" : "J";
        int a = personalityMap.get("A");
        int n = personalityMap.get("N");
        answer +=  a < n? "N" : "A";

        return answer;
    }

    private static void putPersonality(Map<String, Integer> map, String[] split, int x, int score) {
        int sum = map.get(split[x])+ score;
        map.put(split[x], sum);
    }

}
