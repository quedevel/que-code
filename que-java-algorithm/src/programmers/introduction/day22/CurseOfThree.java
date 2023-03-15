package programmers.introduction.day22;

public class CurseOfThree {
    public static void main(String[] args) {
        CurseOfThree curseOfThree = new CurseOfThree();
        System.out.println(curseOfThree.solution(15));
        System.out.println(curseOfThree.solution(40));
    }
    public int solution(int n) {
        int[] arr = new int[n];
        int j = 1;
        for (int i = 0; i < n; i++) {
            while(j%3 == 0 || (j+"").contains("3")){
                j++;
            }
            arr[i] = j;
            j++;
        }
        return arr[n-1];
    }
}
