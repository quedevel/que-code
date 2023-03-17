package programmers.level1;

public class ColatzConjecture {
    public static void main(String[] args) {
        ColatzConjecture colatzConjecture = new ColatzConjecture();
//        System.out.println(colatzConjecture.solution(6));
//        System.out.println(colatzConjecture.solution(16));
        System.out.println(colatzConjecture.solution(626331));
    }
    public int solution(long num) {
        if (num == 1) return 0;
        int count = 0;
        while(true){
            System.out.print(num + " -> ");
            if (isEven(num)){
                num /= 2;
            } else {
                num *= 3;
                num += 1;
            }
            count++;
            if (num == 1){
                System.out.print(num + " : ");
                return count;
            } else if ( count == 500 ){
                return -1;
            }
        }
    }

    private static boolean isEven(long num){
        return num%2 == 0;
    }

}
