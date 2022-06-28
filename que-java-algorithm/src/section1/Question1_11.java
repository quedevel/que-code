package section1;

import java.util.Scanner;

public class Question1_11 {
    public static void solution(String str){
        String result = "";
        int cnt = 0;
        char c = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c){
                cnt++;
                if (i == str.length()-1) result += c+""+cnt;
            } else {
                c = str.charAt(i);
                if (cnt > 1){
                    result += str.charAt(i-1)+""+cnt;
                } else {
                    result += str.charAt(i-1);
                }
                if (i == str.length()-1){
                    result += c;
                }
                cnt = 1;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solution(str);
    }
}