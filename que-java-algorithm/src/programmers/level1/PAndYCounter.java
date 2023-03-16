package programmers.level1;

public class PAndYCounter {
    public static void main(String[] args) {
        PAndYCounter pAndYCounter = new PAndYCounter();
        System.out.println(pAndYCounter.solution("pPoooyY"));
        System.out.println(pAndYCounter.solution("Pyy"));
    }

    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        String str = s.toLowerCase();
        String[] split = str.split("");
        for (String s1 : split) {
            switch (s1) {
                case "p" : pCount++; break;
                case "y" : yCount++; break;
            }
        }
        return pCount == yCount;
    }
}
