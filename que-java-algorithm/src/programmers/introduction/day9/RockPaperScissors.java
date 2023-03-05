package programmers.introduction.day9;

public class RockPaperScissors {
    public static void main(String[] args) {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        System.out.println(rockPaperScissors.solution("2"));
        System.out.println(rockPaperScissors.solution("205"));
    }
    public String solution(String rsp) {
        String answer = "";
        for(String s : rsp.split("")){
            switch (s){
                case "2" : answer += "0"; break;
                case "0" : answer += "5"; break;
                case "5" : answer += "2"; break;
            }
        }
        return answer;
    }
}
