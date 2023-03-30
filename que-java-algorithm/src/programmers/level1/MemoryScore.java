package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryScore {
    public static void main(String[] args) {
        MemoryScore memoryScore = new MemoryScore();
        System.out.println(Arrays.toString(
                memoryScore.solution(new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})
        ));
        System.out.println(Arrays.toString(
                memoryScore.solution(new String[]{"kali", "mari", "don"},
                        new int[]{11, 1, 55},
                        new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}})
        ));
        System.out.println(Arrays.toString(
                memoryScore.solution(new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}})
        ));
    }
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i],
                                (a, b) -> b, HashMap::new)
                );

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                answer[i] += map.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }
}
