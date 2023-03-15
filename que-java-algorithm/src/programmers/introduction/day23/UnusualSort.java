package programmers.introduction.day23;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UnusualSort {
    public static void main(String[] args) {
        UnusualSort unusualSort = new UnusualSort();
        System.out.println(Arrays.toString(unusualSort.solution(new int[]{1,2,3,4,5,6},4)));
        System.out.println(Arrays.toString(unusualSort.solution(new int[]{10000,20,36,47,40,6,10,7000},30)));
    }
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];

        List<Integer> collect = Arrays.stream(numlist).boxed().collect(Collectors.toList());

        Collections.sort(collect, (o1, o2) -> {
            int x = Math.abs(o1-n);
            int y = Math.abs(o2-n);
            return (x!=y)? x-y : o2-o1;
        });

        for (int i = 0; i < collect.size(); i++) {
            answer[i] = collect.get(i);
        }

        return answer;
    }
}
