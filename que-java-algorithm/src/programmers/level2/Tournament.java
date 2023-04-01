package programmers.level2;

public class Tournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        System.out.println(tournament.solution(8,4,7));

    }

    //     4          7            1 2
    //  1     4     5     7      1 2 3 4
    // 1  2  3  4  5  6  7  8
    public int solution(int n, int a, int b) {
        int answer = 0;
        while(a != b){
            answer++;
            a = (a+1)/2;
            b = (b+1)/2;
        }
        return answer;
    }
}
