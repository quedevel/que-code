package programmers.level1;

public class PhoneNumberMasker {
    public static void main(String[] args) {
        PhoneNumberMasker phoneNumberMasker = new PhoneNumberMasker();
        System.out.println(phoneNumberMasker.solution("01033334444"));
    }
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        String substring = phone_number.substring(length - 4, length);
        for (int i = 0; i < length - 4; i++) {
            answer += "*";
        }
        answer += substring;
        return answer;
    }
}
