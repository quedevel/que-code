package codility.lesson.arrays;

public class CyclicRotation {
    public static int[] solution(int[] A, int K) {
        if(A.length <= 1 || K%A.length == 0) return A;
        int[] result = new int[A.length];
        int right = K%A.length;
        for (int i = 0; i < A.length; i++) {
            if (i + right < A.length){
                result[i+right] = A[i];
            } else {
                result[i+right-A.length] = A[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] iArr = {3, 8, 9, 7, 6};
        int cnt = 3;
        solution(iArr, cnt);
    }
}
