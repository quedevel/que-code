package section1;

import java.util.Scanner;

public class Question1_5 {
    public static String solution(String str){
        String result = "";
        char[] cArr = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;
        while(lt < rt){
            if (!Character.isAlphabetic(cArr[lt])){
                lt++;
            } else if (!Character.isAlphabetic(cArr[rt])) {
                rt--;
            } else {
                char temp = cArr[lt];
                cArr[lt] = cArr[rt];
                cArr[rt] = temp;
                lt++;
                rt--;
            }
        }
        result = String.valueOf(cArr);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
