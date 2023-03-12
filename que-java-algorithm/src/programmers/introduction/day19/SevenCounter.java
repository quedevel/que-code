package programmers.introduction.day19;

public class SevenCounter {
    public static void main(String[] args) {
        SevenCounter sevenCounter = new SevenCounter();
        System.out.println(sevenCounter.solution(new int[]{7,77,17}));
        System.out.println(sevenCounter.solution(new int[]{10,29}));
    }
    public int solution(int[] array) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            String s = array[i] + "";
            String[] split = s.split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("7")){
                    answer++;
                }
            }
        }
        return answer;
    }
}
