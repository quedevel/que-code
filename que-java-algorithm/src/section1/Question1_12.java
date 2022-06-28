package section1;

import java.util.Scanner;

public class Question1_12 {
    public static void solution(int cnt, String str){
        String result = "";
        String[] sArr = new String[cnt];
        String temp = str.trim().replaceAll("#","1").replaceAll("\\*","0");
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = temp.substring(0,7);
            temp = temp.substring(7,temp.length());
        }
        for (String s : sArr) {
            int test = Integer.parseInt(s,2);
            char c = (char)test;
            result += c;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        String str = sc.next();
        solution(cnt, str);
    }
}