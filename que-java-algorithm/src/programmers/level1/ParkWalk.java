package programmers.level1;

import java.util.Arrays;

public class ParkWalk {
    public static void main(String[] args) {
        ParkWalk parkWalk = new ParkWalk();
        System.out.println(Arrays.toString(parkWalk.solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(parkWalk.solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(parkWalk.solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
        System.out.println(Arrays.toString(parkWalk.solution(new String[]{"OSO0000X0","OOO000000","0X0000OXO","OOO0000XX"}, new String[]{"E 1","S 2","W 3","N 4","E 5","S 6","W 7","N 8","E 9","S 9"})));
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int xMax = park.length-1;
        int yMax = park[0].length()-1;
        for (int i = 0; i < park.length; i++) {
            String[] split = park[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("S")){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] split = routes[i].split(" ");
            String direction = split[0];
            int distance = Integer.parseInt(split[1]);
            switch (direction){
                case "E" : {
                    if(answer[1]+distance <= yMax){
                        boolean flag = validationRightAndLeft(answer[1], answer[1] + distance, park, answer);
                        if (flag){
                            answer[1] += distance;
                        }
                    }
                    break;
                }
                case "S" : {
                    if (answer[0]+distance <= xMax){
                        boolean flag = validationUpAndDown(answer[0], answer[0] + distance, park, answer);
                        if (flag){
                            answer[0] += distance;
                        }
                    }
                    break;
                }
                case "W" : {
                    if(answer[1]-distance >= 0){
                        boolean flag = validationRightAndLeft(answer[1] - distance, answer[1], park, answer);
                        if (flag){
                            answer[1] -= distance;
                        }
                    }
                    break;
                }
                case "N" : {
                    if (answer[0]-distance >= 0){
                        boolean flag = validationUpAndDown(answer[0] - distance, answer[0], park, answer);
                        if (flag){
                            answer[0] -= distance;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }

    private static boolean validationUpAndDown(int answer, int answer1, String[] park, int[] answer2) {
        boolean flag = true;
        for (int j = answer; j <= answer1; j++) {
            if(park[j].charAt(answer2[1]) == 'X'){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean validationRightAndLeft(int answer, int answer1, String[] park, int[] answer2) {
        boolean flag = true;
        for (int j = answer; j <= answer1; j++) {
            if (park[answer2[0]].charAt(j) == 'X'){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
