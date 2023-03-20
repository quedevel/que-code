package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class PairOfNumbers {
    public static void main(String[] args) {
        PairOfNumbers pairOfNumbers = new PairOfNumbers();
        System.out.println(pairOfNumbers.solution("100","2345"));
        System.out.println(pairOfNumbers.solution("100","203045"));
        System.out.println(pairOfNumbers.solution("100","123450"));
        System.out.println(pairOfNumbers.solution("12321","42531"));
        System.out.println(pairOfNumbers.solution("5525","1255"));
    }
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        String[] splitX = X.split("");
        String[] splitY = Y.split("");
        Map<String, Integer> mapX = new HashMap<>();
        Map<String, Integer> mapY = new HashMap<>();
        for (int i = 0; i < splitX.length; i++) {
            if (mapX.containsKey(splitX[i])) {
                int cnt = mapX.get(splitX[i]) + 1;
                mapX.put(splitX[i], cnt);
            } else {
                mapX.put(splitX[i], 1);
            }
        }
        for (int i = 0; i < splitY.length; i++) {
            if (mapY.containsKey(splitY[i])) {
                int cnt = mapY.get(splitY[i]) + 1;
                mapY.put(splitY[i], cnt);
            } else {
                mapY.put(splitY[i], 1);
            }
        }
        int cnt = 0;
        for (int i = 9; i >= 0; i--) {
            if (mapX.containsKey(i+"") && mapY.containsKey(i+"")){
                cnt++;
                if (i == 0 && answer.length() == 0){
                    return "0";
                }
                int valX = mapX.get(i+"");
                int valY = mapY.get(i+"");
                int commonCount = valX > valY? valY : valX;
                for (int j = 0; j < commonCount; j++) {
                    answer.append(i);
                }
            }
        }
        if (cnt == 0) return "-1";
        return answer.toString();
    }
}
