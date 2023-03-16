package programmers.level1;

public class ModuloOneFinder {
    public static void main(String[] args) {
        ModuloOneFinder moduloOneFinder = new ModuloOneFinder();
        System.out.println(moduloOneFinder.solution(10));
        System.out.println(moduloOneFinder.solution(12));
    }
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (n%i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
