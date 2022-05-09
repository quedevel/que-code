package section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Question6 {
    public static String solution(String str){
        String result = "";
        String[] sArr = str.split("");
        List<String> list = new ArrayList<>();
        for (String s : sArr) {
            if(!list.contains(s)) list.add(s);
        }
        result = list.stream().collect(Collectors.joining());
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
