package programmers.level1;

import java.util.Arrays;

public class DartGame {
    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        System.out.println(dartGame.solution("1S2D*3T"));
        System.out.println(dartGame.solution("1D2S#10S"));
        System.out.println(dartGame.solution("1D2S0T"));
        System.out.println(dartGame.solution("1S*2T*3S"));
        System.out.println(dartGame.solution("1D#2S*3S"));
        System.out.println(dartGame.solution("1T2D3D#"));
        System.out.println(dartGame.solution("1D2S3T*"));
    }
    public int solution(String dartResult) {
        String[] arr = new String[3];
        Arrays.fill(arr, "");
        int arrIndex = -1;

        String[] split = dartResult.split("");
        boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            if (isNumber(split[i]) && flag == false){
                if (split[i].equals("1") && split[i+1].equals("0")) {
                    flag = true;
                }
                arrIndex++;
                arr[arrIndex] += split[i];
            } else {
                arr[arrIndex] += split[i];
                if (flag) {
                    flag = false;
                }
            }
        }

        int[] score = new int[3];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String[] strArr = s.split("");
            int num = !strArr[0].equals("1")? Integer.valueOf(strArr[0]) : strArr[1].equals("0")? 10 : Integer.valueOf(strArr[0]);
            int start = !strArr[0].equals("1")? 1 : strArr[1].equals("0")? 2 : 1;
            for (int j = start; j < strArr.length; j++) {
                switch (strArr[j]) {
                    case "D" :
                        num = (int) Math.pow(num, 2);
                        break;
                    case "T" :
                        num = (int) Math.pow(num, 3);
                        break;
                    case "*" :
                        if (i != 0) {
                            score[i - 1] = score[i - 1] * 2;
                        }
                            num = num*2;
                        break;
                    case "#" :
                        num *= -1;
                        break;
                }
            }
            score[i] = num;
        }
        return Arrays.stream(score).sum();
    }
    private static boolean isNumber(String s){
        try{
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
