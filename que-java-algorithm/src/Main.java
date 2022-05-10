import java.util.Scanner;

public class Main {
    public static int[] solution(String s, char t){
        int[] answer=new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            p = s.charAt(i) == t? 0 : p+1;
            answer[i] = p;
        }
        p = 1000;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == t){
                p = 0;
            } else {
                p++;
            }
            answer[i] = Math.min(answer[i],p);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int i : solution(str, c)){
            System.out.print(i+" ");
        }
    }
}
