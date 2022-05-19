package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] sArr = s.trim().split(" ");
        List<String> list = Arrays.stream(sArr).map(String::trim).filter(s1 -> !s1.isEmpty()).collect(Collectors.toList());
        return list.get(list.size()-1).length();
    }

    public static void main(String[] args) {
        String s = "  Hell      World  ";
        lengthOfLastWord(s);
    }
}
