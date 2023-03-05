package programmers.introduction.day18;

public class SquareDetector {
    public static void main(String[] args) {
        SquareDetector squareDetector = new SquareDetector();
        System.out.println(squareDetector.solution(144));
        System.out.println(squareDetector.solution(976));
    }
    public int solution(int n) {
        int answer = 2;
        for (int i = 1; i < n; i++) {
            if(i*i == n){
                answer = 1;
                break;
            } else if (i*i >n){
                break;
            }
        }
        return answer;
    }
}
