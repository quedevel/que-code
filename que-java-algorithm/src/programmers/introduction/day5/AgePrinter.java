package programmers.introduction.day5;

public class AgePrinter {

    public static void main(String[] args) {
        AgePrinter agePrinter = new AgePrinter();
        System.out.println(agePrinter.solution(40));
        System.out.println(agePrinter.solution(23));
    }

    public int solution(int age) {
        int standard = 2022;
        return standard - age + 1;
    }

}
