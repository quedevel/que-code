package programmers.introduction.day9;


public class MorseCodeConverter {
    public static void main(String[] args) {
        MorseCodeConverter morseCodeConverter = new MorseCodeConverter();
        System.out.println(morseCodeConverter.solution(".... . .-.. .-.. ---"));
        System.out.println(morseCodeConverter.solution(".--. -.-- - .... --- -."));
    }
    public String solution(String letter) {
        String[] morse = new String[]{
                ".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.",
                "...","-","..-","...-",".--","-..-",
                "-.--","--.."
        };
        String answer = "";
        String[] split = letter.split(" ");
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < morse.length; j++) {
                if (split[i].equals(morse[j])){
                    int code = j+97;
                    answer += Character.valueOf((char) code);
                }
            }
        }
        return answer;
    }
}
