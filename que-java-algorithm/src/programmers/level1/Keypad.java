package programmers.level1;

public class Keypad {
    public static void main(String[] args) {
        Keypad keypad = new Keypad();
        System.out.println(keypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right")); // LRLLLRLLRRL
        System.out.println(keypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left")); // LRLLRRLLLRR
        System.out.println(keypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right")); // LLRLLRLLRL
    }
    /*
    *   1   2   3
    *   4   5   6
    *   7   8   9
    *   *   0   #
    */
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        final String RIGHT_HAND = "right";
        final String RIGHT = "R";
        final String LEFT_HAND = "left";
        final String LEFT = "L";

        int beforeLeft = 10;
        int beforeRight = 12;

        for (int num : numbers) {
            if (num == 0) num = 11;
            switch (num%3) {
                case 1: {
                    beforeLeft = num;
                    sb.append(LEFT);
                    break;
                }
                case 0: {
                    beforeRight = num;
                    sb.append(RIGHT);
                    break;
                }
                case 2: {
                    int curLeft = Math.abs(num-beforeLeft)/3+Math.abs(num-beforeLeft)%3;
                    int curRight = Math.abs(num-beforeRight)/3+Math.abs(num-beforeRight)%3;
                    if (curLeft == curRight){
                        if (hand.equals(RIGHT_HAND)){
                            beforeRight = num;
                            sb.append(RIGHT);
                        } else if (hand.equals(LEFT_HAND)) {
                            beforeLeft = num;
                            sb.append(LEFT);
                        }
                    } else if (curLeft < curRight){
                        beforeLeft = num;
                        sb.append(LEFT);
                    } else {
                        beforeRight = num;
                        sb.append(RIGHT);
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
}
