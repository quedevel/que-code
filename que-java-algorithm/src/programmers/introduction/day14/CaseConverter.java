package programmers.introduction.day14;

public class CaseConverter {
    public static void main(String[] args) {
        CaseConverter caseConverter = new CaseConverter();
        System.out.println(caseConverter.solution("cccCCC"));
        System.out.println(caseConverter.solution("abCdEfghIJ"));
    }
    public String solution(String my_string) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        for (char c : chars) {
            if(c > 96 && c < 123){
                answer += Character.valueOf((char) (c-32));
            } else if (c > 64 && c < 91){
                answer += Character.valueOf((char) (c+32));
            }
        }
        return answer;
    }

}
