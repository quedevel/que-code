import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void solution(String s1, String s2){
        String sortedS1 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
        String sortedS2 = Stream.of(s2.split("")).sorted().collect(Collectors.joining());
        System.out.println(sortedS1.equals(sortedS2)? "YES": "NO");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        solution(s1, s2);
    }
}
