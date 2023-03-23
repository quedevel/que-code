package programmers.level1;

public class StringSplitter {
    public static void main(String[] args) {
        StringSplitter stringSplitter = new StringSplitter();
        System.out.println(stringSplitter.solution("banana"));
        System.out.println(stringSplitter.solution("abracadabra"));
        System.out.println(stringSplitter.solution("aaabbaccccabba"));
    }
    public int solution(String s) {
        int answer = 0;
        while(s.length() > 0){
            int xCnt = 0;
            int yCnt = 0;
            char x = s.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == x){
                    xCnt++;
                } else {
                    yCnt++;
                }
                if(xCnt == yCnt){
                    s = s.substring(i+1);
                    answer++;
                    break;
                } else if (i+1 >= s.length()){
                    s = "";
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
