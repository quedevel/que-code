package programmers.introduction.day13;

public class DuplicateRemover {
    public static void main(String[] args) {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        System.out.println(duplicateRemover.solution("people"));
        System.out.println(duplicateRemover.solution("We are the world"));
    }
    public String solution(String my_string) {
        String answer = "";
        String[] split = my_string.split("");
        for (int i = 0; i < split.length; i++) {
            if(answer.indexOf(split[i]) == -1){
                answer += split[i];
            }
        }
        return answer;
    }
}
