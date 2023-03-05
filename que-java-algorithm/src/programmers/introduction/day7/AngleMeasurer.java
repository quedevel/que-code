package programmers.introduction.day7;

public class AngleMeasurer {

    public static void main(String[] args) {
        AngleMeasurer angleMeasurer = new AngleMeasurer();
        System.out.println(angleMeasurer.solution(70));
        System.out.println(angleMeasurer.solution(91));
        System.out.println(angleMeasurer.solution(180));
    }

    public int solution(int angle) {
        return angle == 90? 2 : angle == 180? 4 : angle < 90? 1 : 3;
    }
}
