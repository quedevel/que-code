package programmers.introduction.day25;

public class StringShifter {
    public static void main(String[] args) {
        StringShifter stringShifter = new StringShifter();
        System.out.println(stringShifter.solution("hello","ohell"));
        System.out.println(stringShifter.solution("apple","elppa"));
        System.out.println(stringShifter.solution("atat","tata"));
        System.out.println(stringShifter.solution("abc","abc"));
    }
    public int solution(String A, String B) {
        if (A.equals(B)) return 0;
        String[] shift = new String[A.length()];
        for (int i = 0; i < shift.length; i++) {
            String[] split = A.split("");
            String temp = split[split.length-1];
            for (int j = 0; j < split.length-1; j++) {
                temp += split[j];
            }
            shift[i] = temp;
            A = temp;
        }
        for (int i = 0; i < shift.length; i++) {
            if (B.equals(shift[i])) return i+1;
        }
        return -1;
    }
}
