package section1;

import java.util.Scanner;

public class Question1_4 {
    public static void solution(String str){
        StringBuffer sb = new StringBuffer(str);
        String s = sb.reverse().toString();
        System.out.println(s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if(cnt >= 3 && cnt <= 20){
            for (int i = 0; i < cnt; i++) {
                String str = sc.nextLine();
                if("".equals(str)) str = sc.nextLine();
                solution(str);
            }
        }
    }
}
