package programmers.introduction.etc;

import java.util.ArrayList;
import java.util.List;

public class HiddenNumberAdder {
    public static void main(String[] args) {
        HiddenNumberAdder hiddenNumberAdder = new HiddenNumberAdder();
        System.out.println(hiddenNumberAdder.solution("aAb1B2cC34oOp"));
        System.out.println(hiddenNumberAdder.solution("1a2b3c4d123Z"));
    }
    public int solution(String my_string) {
        String before = "";
        List<Integer> list = new ArrayList<>();
        String[] split = my_string.split("");
        for (int i = 0; i < split.length; i++) {
            if (isNumber(before)){
                if (isNumber(split[i])){
                    before += split[i];
                } else {
                    list.add(Integer.valueOf(before));
                    before = "";
                }
            } else {
                before = split[i];
            }
        }
        if (isNumber(before)){
            list.add(Integer.valueOf(before));
        }
        return list.stream().reduce(0,(a,b)->a+b);
    }

    private static boolean isNumber(String s){
        try{
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
