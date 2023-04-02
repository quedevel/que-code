package programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) {
        Cache cache = new Cache();
//        System.out.println(cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
//        System.out.println(cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"	}));
//        System.out.println(cache.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(cache.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
//        System.out.println(cache.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
//        System.out.println(cache.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(cache.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        int totalTime = 0;
        Queue<String> queue = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (queue.contains(city)){
                queue.remove(city);
                queue.add(city);
                totalTime++;
            } else {
                totalTime += 5;
                if (queue.size() >= cacheSize){
                    queue.poll();
                }
                queue.add(city);
            }
        }
        return totalTime;
    }
}
