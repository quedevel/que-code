package programmers.level1;

public class Year2016 {
    public static void main(String[] args) {
        Year2016 year2016 = new Year2016();
        System.out.println(year2016.solution(5,6));
        System.out.println(year2016.solution(5,24));
    }
    public String solution(int a, int b) {
        String answer = "";
        int sum = b-1;
        for (int i = 1; i < a; i++) {
            switch (i) {
                case 1 :
                case 3 :
                case 5 :
                case 7 :
                case 8 :
                case 10 :
                case 12 :
                    sum += 31; break;
                case 4 :
                case 6 :
                case 9 :
                case 11 :
                    sum += 30; break;
                case 2 : sum += 29; break;
            }
        }
        switch (sum%7) {
            case 0 : answer = "FRI"; break;
            case 1 : answer = "SAT"; break;
            case 2 : answer = "SUN"; break;
            case 3 : answer = "MON"; break;
            case 4 : answer = "TUE"; break;
            case 5 : answer = "WED"; break;
            case 6 : answer = "THU"; break;
        }
        return answer;
    }
}
