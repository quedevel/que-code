package section1;

import java.util.Scanner;

public class Question8 {
    public static String solution(String str){
        String result = "";
        String onlyEng = "";
        for(char c : str.toCharArray()){
            if (Character.isAlphabetic(c)) onlyEng += c;
        }
        StringBuffer sb = new StringBuffer(onlyEng);
        String temp = sb.reverse().toString();
        result = onlyEng.equals(temp)? "YES" : "NO";
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str.toLowerCase()));
    }
}
