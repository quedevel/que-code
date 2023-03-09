package programmers.introduction.day14;

import java.util.Arrays;

public class Proximity {
    public static void main(String[] args) {
        Proximity proximity = new Proximity();
        System.out.println(proximity.solution(new int[]{3,10,28},20));
        System.out.println(proximity.solution(new int[]{10,11,12},13));
    }
    public int solution(int[] array, int n) {
        int answer = 0;
        int[] arr = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }
        arr[array.length] = n;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n){
                if (i == 0){
                    answer = arr[i+1];
                } else if (i == arr.length-1){
                    answer = arr[i-1];
                } else {
                    int a = n - arr[i-1];
                    int b = arr[i+1] - n;
                    answer = a <= b ? arr[i]-1 : arr[i+1];
                }
                break;
            }
        }
        return answer;
    }
}
