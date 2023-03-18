package programmers.level1;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();
        System.out.println(Arrays.toString(secretMap.solution(5,new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28})));
        System.out.println(Arrays.toString(secretMap.solution(6,new int[]{46,33,33,22,31,50},new int[]{27,56,19,14,14,10})));

    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String s1 = Integer.toString(arr1[i], 2);
            s1 = getString(n, s1);

            String s2 = Integer.toString(arr2[i], 2);
            s2 = getString(n, s2);

            String[] s1Arr = s1.split("");
            String[] s2Arr = s2.split("");
            String str = "";
            for (int j = 0; j < s1Arr.length; j++) {
                if (s1Arr[j].equals("0") && s2Arr[j].equals("0")){
                    str += " ";
                } else {
                    str += "#";
                }
            }
            answer[i] = str;
        }
        return answer;
    }

    private static String getString(int n, String s) {
        if (s.length() < n){
            String s2Prefix = "";
            for (int j = 0; j < n - s.length(); j++) {
                s2Prefix += "0";
            }
            s = s2Prefix + s;
        }
        return s;
    }
}
