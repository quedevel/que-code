package programmers.introduction.day14;

public class CipherDecoder {
    public static void main(String[] args) {
        CipherDecoder cipherDecoder = new CipherDecoder();
        System.out.println(cipherDecoder.solution("dfjardstddetckdaccccdegk",4));
        System.out.println(cipherDecoder.solution("pfqallllabwaoclk",2));
    }
    public String solution(String cipher, int code) {
        String answer = "";
        String[] split = cipher.split("");
        for (int i = 1; i <= split.length/code; i++) {
            answer += split[code*i-1];
        }
        return answer;
    }
}
