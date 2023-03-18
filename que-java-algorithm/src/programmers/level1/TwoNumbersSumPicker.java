package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoNumbersSumPicker {
    public static void main(String[] args) {
        TwoNumbersSumPicker twoNumbersSumPicker = new TwoNumbersSumPicker();
        System.out.println(Arrays.toString(twoNumbersSumPicker.solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(twoNumbersSumPicker.solution(new int[]{5,0,2,7})));
    }
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int n = numbers[i] + numbers[j];
                if (!list.contains(n)){
                    list.add(n);
                }
            }
        }

        list = list.stream().sorted().collect(Collectors.toList());

        int size = list.size();

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
