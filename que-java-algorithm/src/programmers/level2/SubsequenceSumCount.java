package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubsequenceSumCount {
    public static void main(String[] args) {
        SubsequenceSumCount subsequenceSumCount = new SubsequenceSumCount();
        System.out.println(subsequenceSumCount.solution(new int[]{7,9,1,1,4}));
    }
    public int solution(int[] elements) {
        int elementsLength = elements.length;
        int[] doubleElements = new int[elementsLength *2];
        for (int i = 0; i < elementsLength; i++) {
            doubleElements[i] = doubleElements[i + elementsLength] = elements[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elementsLength; i++) {
            for (int j = 0; j < elementsLength; j++) {
                int sum = Arrays.stream(doubleElements, j, j + i).sum();
                set.add(sum);
            }
        }
        return set.size();
    }
}
