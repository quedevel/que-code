package programmers.level2;


public class NextBiggerNumber {
    public static void main(String[] args) {
        NextBiggerNumber nextBiggerNumber = new NextBiggerNumber();
//        System.out.println(nextBiggerNumber.solution(78));
        System.out.println(nextBiggerNumber.solution(100000));
    }
    public int solution(int n) {
        int initialValue = n;
        while(true){
            n++;
            if (compareOneCountOfBinary(initialValue, n)){
                return n;
            }
        }
    }
    private static boolean compareOneCountOfBinary(int x, int y){
        String xToBinaryString = Integer.toBinaryString(x);
        String yToBinaryString = Integer.toBinaryString(y);

        int xCount = 0;
        int yCount = 0;

        for (int i = 0; i < yToBinaryString.length(); i++) {
            if (yToBinaryString.charAt(i) == '1') yCount++;
            if (i <= xToBinaryString.length()-1 && xToBinaryString.charAt(i) == '1') xCount++;
        }

//        루프 2번 돌리는건 효율이 개똥이다! 실패!
//        long xCount = Arrays.stream(xToBinaryString.split(""))
//                .filter(xStr -> xStr.equals("1"))
//                .count();
//        long yCount = Arrays.stream(yToBinaryString.split(""))
//                .filter(yStr -> yStr.equals("1"))
//                .count();

        return xCount == yCount;
    }
}
