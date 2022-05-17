package leetcode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length > 0){
            char[] cArr = strs[0].toCharArray();
            for (int i = 0; i < cArr.length; i++) {
                boolean flag = true;
                for (int j = 0; j < strs.length; j++) {
                    if (i > strs[j].length()-1){
                        flag = false;
                        break;
                    }
                    if (cArr[i] != strs[j].charAt(i)){
                        flag = false;
                    }
                }
                if (flag){
                    prefix += cArr[i];
                } else {
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] sArr = {"abc","a"};
        System.out.println(longestCommonPrefix(sArr));
    }
}
