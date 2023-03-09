package programmers.introduction.day15;

public class EnglishDislike {
    public static void main(String[] args) {
        EnglishDislike englishDislike = new EnglishDislike();
        System.out.println(englishDislike.solution("onetwothreefourfivesixseveneightnine"));
        System.out.println(englishDislike.solution("onefourzerosixseven"));
    }
    public long solution(String numbers) {
        String str = numbers.replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9")
                .replaceAll("zero", "0");
        return Long.valueOf(str);
    }

}
