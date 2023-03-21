package programmers.level1;

public class BabyCry {
    public static void main(String[] args) {
        BabyCry babyCry = new BabyCry();
        System.out.println(babyCry.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(babyCry.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
    public int solution(String[] babbling) {
        int answer = 0;
        String[] base = {"aya","ye","woo","ma"};
        for (int i = 0; i < babbling.length; i++) {
            String before = "";
            while(true){
                int cnt = 0;
                for (int j = 0; j < base.length; j++) {
                    if (babbling[i].indexOf(base[j]) == 0){
                        if (before.equals(base[j])) {
                            cnt = base.length;
                            break;
                        }
                        babbling[i] = babbling[i].replaceFirst(base[j],"");
                        before = base[j];
                    } else {
                        cnt++;
                    }
                }
                if (cnt >= base.length){
                    break;
                }
            }
            if("".equals(babbling[i])) answer++;
        }
        return answer;
    }
}
