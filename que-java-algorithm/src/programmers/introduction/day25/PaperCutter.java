package programmers.introduction.day25;

public class PaperCutter {
    public static void main(String[] args) {
        PaperCutter paperCutter = new PaperCutter();
        System.out.println(paperCutter.solution(2,2));
        System.out.println(paperCutter.solution(2,5));
        System.out.println(paperCutter.solution(1,1));
    }
    public int solution(int M, int N) {
        int max = M > N? M : N;
        int min = M > N? N : M;
        return (min-1) +(min)*(max-1);
    }
}
