package programmers.level2;

import java.util.*;

public class ClothingCombiner {
    public static void main(String[] args) {
        ClothingCombiner clothingCombiner = new ClothingCombiner();
        System.out.println(clothingCombiner.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}));
        System.out.println(clothingCombiner.solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}}));
    }
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String value = cloth[0];
            String key = cloth[1];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(value);
        }

        int answer = 1;
        for (String s : map.keySet()) {
            answer *= (map.get(s).size()+1);
        }
        return answer-1;
    }
}
