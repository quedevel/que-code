package programmers.level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PickingTangerines {
    public static void main(String[] args) {
        PickingTangerines pickingTangerines = new PickingTangerines();
        System.out.println(pickingTangerines.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(pickingTangerines.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(pickingTangerines.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> sortedKeys = map.keySet().stream()
                .sorted(Comparator.comparing(map::get).reversed())
                .collect(toList());

        int answer = 0;
        for (int key : sortedKeys) {
            k -= map.get(key);
            answer++;
            if (k <= 0){
                break;
            }
        }
        return answer;
    }
}
