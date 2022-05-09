package section1;

import java.util.Scanner;

public class Question7 {
    public static String solution(String str){
        String result = "";
        StringBuffer sb = new StringBuffer(str);
        String temp = sb.reverse().toString();
        result = str.equals(temp)? "YES" : "NO";
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str.toLowerCase()));
    }
}
