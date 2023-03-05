package programmers.introduction.day7;

public class LambSkewer {

    public static void main(String[] args) {
        LambSkewer lambSkewer = new LambSkewer();
        System.out.println(lambSkewer.solution(10,3));
        System.out.println(lambSkewer.solution(64,6));
    }
    public int solution(int n, int k) {
        return n * 12000 + k * 2000 - (n / 10) * 2000;
    }


}
