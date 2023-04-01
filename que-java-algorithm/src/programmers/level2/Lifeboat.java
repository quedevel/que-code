package programmers.level2;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        Lifeboat lifeboat = new Lifeboat();
        System.out.println(lifeboat.solution(new int[]{70,50,80,50},100));
        System.out.println(lifeboat.solution(new int[]{70,80,50},100));
    }
    // 최대 2명
    // 가벼운 사람 + 무거운 사람
    // 50 50 70 80
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int lighter = 0;
        int heavier = people.length-1;

        while(lighter <= heavier){
            if (people[lighter] + people[heavier] <= limit){
                lighter++;
                heavier--;
            } else {
                heavier--;
            }
            answer++;
        }
        return answer;
    }
}
