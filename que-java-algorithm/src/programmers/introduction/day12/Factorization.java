package programmers.introduction.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Factorization {
    public static void main(String[] args) {
        Factorization factorization = new Factorization();
        for (int i = 2; i <= 10000; i++) {
            System.out.println(i+" => "+Arrays.toString(factorization.solution(i)));
        }
    }
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            while(n%i == 0){
                set.add(i);
                n /= i;
            }
        }
        int[] answer = new int[set.size()];
        int j = 0;
        for (int num : set) {
            answer[j] = num;
            j++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
