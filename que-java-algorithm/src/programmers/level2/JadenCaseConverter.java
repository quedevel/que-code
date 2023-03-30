package programmers.level2;

public class JadenCaseConverter {
    public static void main(String[] args) {
        JadenCaseConverter jadenCaseConverter = new JadenCaseConverter();
        System.out.println(jadenCaseConverter.solution("3people 3unFollowed 3me"));
        System.out.println(jadenCaseConverter.solution("for the last week"));
    }
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("");
        boolean beforeBlank = true;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(" ")){
                beforeBlank = true;
                sb.append(split[i].toLowerCase());
            } else {
                sb.append(beforeBlank ? split[i].toUpperCase() : split[i].toLowerCase());
                beforeBlank = false;
            }
        }
        return sb.toString();
    }
}
