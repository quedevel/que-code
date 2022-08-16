import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Integer> solution(int[] arr){
        List<Integer> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : solution(arr)) {
            System.out.print(x + " ");
        }
    }
}
