package programmers.introduction.day8;

public class AgeOfAlienPlanet {

    public static void main(String[] args) {
        AgeOfAlienPlanet ageOfAlienPlanet = new AgeOfAlienPlanet();
        System.out.println(ageOfAlienPlanet.solution(23));
        System.out.println(ageOfAlienPlanet.solution(51));
        System.out.println(ageOfAlienPlanet.solution(100));
    }
    public String solution(int age) {
        String answer = "";
        String strAge = age+"";
        String[] split = strAge.split("");
        for (String s : split) {
            int cVal = Integer.valueOf(s) + 97;
            answer += Character.valueOf((char) cVal);
        }
        return answer;
    }

}
