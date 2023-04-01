package programmers.level2;

public class Teleportation {
    public static void main(String[] args) {
        Teleportation teleportation = new Teleportation();
        System.out.println(teleportation.solution(5)); // 2
        System.out.println(teleportation.solution(6)); // 2
        System.out.println(teleportation.solution(5000)); // 5
    }

    // 5 2 1
    // 6 3 2 1
    // 5000 2500 1250 625 312 156 78 39 19 9 4 2 1
    public int solution(int n) {
        int answer = 1;
        while(n/2 != 0){
            if (!isEven(n)) answer++;
            n /= 2;
        }
        return answer;
    }

    private static boolean isEven(int n){
        return n%2 == 0;
    }
}
