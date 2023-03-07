package programmers.introduction.day10;


public class Array2DConverter {
    public static void main(String[] args) {
        int[][] arr = { {1,2},{3,4},{5,6},{7,8} };
        printer(arr);
        Array2DConverter array2DConverter = new Array2DConverter();
        printer(array2DConverter.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8},2));
        printer(array2DConverter.solution(new int[]{100, 95, 2, 4, 5, 6, 18, 33, 948},3));
    }
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        for (int i = 0; i < num_list.length/n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[i*n+j];
            }
        }
        return answer;
    }

    public static void printer(int[][] array){
        System.out.println("----start-----");
        for (int i = 0; i < array.length; i++) {
            int[] inArr = array[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }
        System.out.println("----end----");
    }
}
