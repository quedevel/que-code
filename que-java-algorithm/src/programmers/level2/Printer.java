package programmers.level2;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println(printer.solution(
                new int[]{2,1,3,2},
                2
        ));
        System.out.println(printer.solution(
                new int[]{1,1,9,1,1,1},
                0
        ));
    }
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> prioritiesMap = new HashMap<>();
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i == location));
            prioritiesMap.put(priorities[i], prioritiesMap.getOrDefault(priorities[i], 0)+1);
        }
        int count = 0;
        while(true){
            Document first = queue.poll();
            assert first != null;
            int priority = first.getPriority();
            boolean isFirst = true;
            Set<Integer> keySet = prioritiesMap.keySet();
            for (int key : keySet) {
                if (priority < key && prioritiesMap.get(key) != 0){
                    isFirst = false;
                    break;
                }
            }
            if (isFirst){
                count++;
                prioritiesMap.put(priority, prioritiesMap.get(priority)-1);
                if (first.isLocation()){
                    return count;
                }
            } else {
                queue.add(first);
            }
        }
    }

    static class Document{
        private final int priority;
        private final boolean isLocation;

        public Document(int priority, boolean isLocation) {
            this.priority = priority;
            this.isLocation = isLocation;
        }
        public int getPriority() {
            return priority;
        }

        public boolean isLocation() {
            return isLocation;
        }
    }
}
