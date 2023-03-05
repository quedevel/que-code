package programmers.introduction.day9;

public class AntArmy {

    public static void main(String[] args) {
        AntArmy antArmy = new AntArmy();
        System.out.println(antArmy.solution(23));
        System.out.println(antArmy.solution(24));
        System.out.println(antArmy.solution(999));
    }
    public int solution(int hp) {
        return hp/5 + (hp%5)/3 + (hp%5)%3;
    }
}
