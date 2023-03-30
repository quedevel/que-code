package programmers.level2;

public class NumberRepresentation {
    public static void main(String[] args) {
        NumberRepresentation numberRepresentation = new NumberRepresentation();
        System.out.println(numberRepresentation.solution(1));
    }
    public int solution(int n) {
        int answer = 1;
        if (n == 1) return answer;
        int base = 1;
        int sum = 0;
        while(true){
            for (int i = base; i <= (n/2)+1; i++) {
                sum += i;
                if (sum == n){
                    answer++;
                    base++;
                    sum = 0;
                    break;
                } else if (sum > n){
                    sum = 0;
                    base++;
                    break;
                }
            }
            if (base == (n/2)+1){
                break;
            }
        }
        return answer;
    }
}
