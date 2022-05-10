package section1;

import java.util.*;
import java.util.stream.Collectors;

public class Question10 {
    public static String solution(String s, String t){
        String result = "";
        String[] split = s.split("");
        int p = 1000;
        int q = 1000;

        List<Integer> sList1 = new ArrayList<>();
        List<Integer> sList2 = new ArrayList<>();
        List<Integer> sList3 = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(t)){
                p = 0;
                sList1.add(0);
            } else {
                p++;
                sList1.add(p);
            }
        }
        for (int i = split.length-1; i >= 0; i--) {
            if (split[i].equals(t)){
                q = 0;
                sList2.add(0);
            } else {
                q++;
                sList2.add(q);
            }
        }
        Collections.reverse(sList2);
        for (int i = 0; i < sList1.size(); i++) {
            if(sList1.get(i) >= sList2.get(i)) sList3.add(sList2.get(i));
            else sList3.add(sList1.get(i));
        }
        result = sList3.stream().map(String::valueOf).collect(Collectors.joining(" "));
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] sArr = str.split(" ");
        System.out.println(solution(sArr[0],sArr[1]));
    }
}