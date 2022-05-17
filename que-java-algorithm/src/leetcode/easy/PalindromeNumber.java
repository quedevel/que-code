package leetcode.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuffer sb = new StringBuffer(str);
        String reversedString = sb.reverse().toString();
        return str.equals(reversedString);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
