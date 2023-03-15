package programmers.introduction.day23;

public class BabyCryAnalyzer {
    public static void main(String[] args) {
        BabyCryAnalyzer babyCryAnalyzer = new BabyCryAnalyzer();
        System.out.println(babyCryAnalyzer.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
        System.out.println(babyCryAnalyzer.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }
    public int solution(String[] babbling) {
        int answer = 0;
        String[] base = {"aya","ye","woo","ma"};
        for (int i = 0; i < babbling.length; i++) {
            while(true){
                int cnt = 0;
                for (int j = 0; j < base.length; j++) {
                    if (babbling[i].indexOf(base[j]) == 0){
                        babbling[i] = babbling[i].replace(base[j],"");
                    } else {
                        cnt++;
                    }
                }
                if (cnt == 4){
                    break;
                }
            }
        }
        for (String s : babbling) {
            if ("".equals(s)) answer++;
        }
        return answer;
    }
}
