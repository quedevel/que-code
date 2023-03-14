package programmers.introduction.day20;

import java.util.Arrays;

public class CharacterCoordinate {
    public static void main(String[] args) {
        CharacterCoordinate characterCoordinate = new CharacterCoordinate();
        System.out.println(Arrays.toString(characterCoordinate.solution(new String[]{"left", "right", "up", "right", "right"},new int[]{1,5})));
        System.out.println(Arrays.toString(characterCoordinate.solution(new String[]{"down", "down", "down", "down", "down"},new int[]{99,11})));
    }
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0,0};
        int maxWidth = board[0]/2;
        int maxHeight = board[1]/2;
        for (String s : keyinput) {
            switch (s) {
                case "left" : {
                    if (answer[0]-1 <= maxWidth*-1){
                        answer[0] = maxWidth*-1;
                    } else {
                        answer[0] -= 1;
                    }
                    break;
                }
                case "right" : {
                    if (answer[0]+1 >= maxWidth){
                        answer[0] = maxWidth;
                    } else {
                        answer[0] += 1;
                    }
                    break;
                }
                case "up" : {
                    if(answer[1] + 1 >= maxHeight){
                        answer[1] = maxHeight;
                    } else {
                        answer[1] += 1;
                    }
                    break;
                }
                case "down" : {
                    if(answer[1] - 1 <= maxHeight*-1){
                        answer[1] = maxHeight*-1;
                    } else {
                        answer[1] -= 1;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
