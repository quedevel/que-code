package programmers.level1;

public class StringHandler {
    public static void main(String[] args) {
        StringHandler stringHandler = new StringHandler();
        System.out.println(stringHandler.solution("00000000"));
        System.out.println(stringHandler.solution("99999999"));
        System.out.println(stringHandler.solution("01234567"));
    }
    public boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)){
            return false;
        }
        try{
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
