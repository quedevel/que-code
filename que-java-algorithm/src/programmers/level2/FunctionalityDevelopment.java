package programmers.level2;

import java.util.*;

public class FunctionalityDevelopment {
    public static void main(String[] args) {
        FunctionalityDevelopment functionalityDevelopment = new FunctionalityDevelopment();
//        System.out.println(functionalityDevelopment.solution(
//                new int[]{93, 30, 55},
//                new int[]{1,30,5}
//        ));
//        System.out.println(functionalityDevelopment.solution(
//                new int[]{95, 90, 99, 99, 80, 99},
//                new int[]{1, 1, 1, 1, 1, 1}
//        ));
        System.out.println(functionalityDevelopment.solution(
                new int[]{40, 40, 10, 80, 90, 50},
                new int[]{1, 1, 1, 1, 1, 1}
        ));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remainProgress = 100 - progresses[i];
            int deployDay = remainProgress % speeds[i] == 0? remainProgress/speeds[i] : (remainProgress/speeds[i]) + 1;
            if (!queue.isEmpty() && queue.peek() < deployDay){
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(deployDay);
        }

        list.add(queue.size());

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
