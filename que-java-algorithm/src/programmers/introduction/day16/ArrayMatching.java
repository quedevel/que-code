package programmers.introduction.day16;

public class ArrayMatching {
    public static void main(String[] args) {
        ArrayMatching arrayMatching = new ArrayMatching();
        System.out.println(arrayMatching.solution(new String[]{"a", "b", "c"},new String[]{"com", "b", "d", "p", "c"}));
        System.out.println(arrayMatching.solution(new String[]{"n", "omg"},new String[]{"m", "dot"}));
    }
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String f : s1) {
            for (String s : s2) {
                if (f.equals(s)) answer++;
            }
        }
        return answer;
    }
}
