package programmers.level1;

public class InnerProduct {
    public static void main(String[] args) {
        InnerProduct innerProduct = new InnerProduct();
        System.out.println(innerProduct.solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2}));
        System.out.println(innerProduct.solution(new int[]{-1,0,1}, new int[]{1,0,-1}));
    }
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}
