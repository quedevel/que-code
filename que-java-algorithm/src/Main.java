import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void solution(String S, String T){
        int result = 0;
        int sLength = S.length();
        int tLength = T.length();
        String[] arr = S.split("");
        String standard = Arrays.stream(T.split("")).sorted().collect(Collectors.joining());
        for (int i = 0; i <= sLength - tLength; i++) {
            List<String> list = new ArrayList<>();
            for (int j = i; j < i+tLength; j++) {
                list.add(arr[j]);
            }
            String temp = list.stream().sorted().collect(Collectors.joining());
            if (standard.equals(temp)) result++;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String T = sc.nextLine();
        solution(S, T);
    }
}
