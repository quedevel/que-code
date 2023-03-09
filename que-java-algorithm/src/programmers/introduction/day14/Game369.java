package programmers.introduction.day14;

public class Game369 {
    public static void main(String[] args) {
        Game369 game369 = new Game369();
        System.out.println(game369.solution(3));
        System.out.println(game369.solution(29423));
        System.out.println(game369.solution(1000));
        System.out.println(game369.solution(99999));
    }
    public int solution(int order) {
        int answer = 0;
        while (order/10 >= 1){
            if(order%10 != 0 && order%10%3 == 0){
                answer++;
            }
            order /= 10;
        }
        if(order != 0 && order%10%3 == 0){
            answer++;
        }
        return answer;
    }
}
