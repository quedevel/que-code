package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tuple {
    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        System.out.println(tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        System.out.println(tuple.solution("{{20,111},{111}}"));
        System.out.println(tuple.solution("{{123}}"));
        System.out.println(tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
    public List<Integer> solution(String s) {
        s = s.replace("{{","").replace("}}","").replace("},{","-");
        String[] split = s.split("-");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] elements = split[i].split(",");
            for (int j = 0; j < elements.length; j++) {
                int element = Integer.parseInt(elements[j]);
                if (!answer.contains(element)){
                    answer.add(element);
                }
            }
        }
        return answer;
    }
}
