package programmers.introduction.day8;

import java.util.Arrays;

public class AppointmentOrdering {
    public static void main(String[] args) {
        AppointmentOrdering appointmentOrdering = new AppointmentOrdering();
        System.out.println(Arrays.toString(appointmentOrdering.solution(new int[]{3, 76, 24})));
        System.out.println(Arrays.toString(appointmentOrdering.solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(appointmentOrdering.solution(new int[]{30, 10, 23, 6, 100})));
    }
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] sorted = Arrays.stream(emergency).sorted().toArray();
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if(emergency[i] == sorted[j]) answer[i] = emergency.length-j;
            }
        }
        return answer;
    }
}
