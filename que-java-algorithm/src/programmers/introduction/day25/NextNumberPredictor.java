package programmers.introduction.day25;


public class NextNumberPredictor {
    public static void main(String[] args) {
        NextNumberPredictor nextNumberPredictor = new NextNumberPredictor();
        System.out.println(nextNumberPredictor.solution(new int[]{2,1,0,-1,-2,-3,-4,-5,-6,-7}));
        System.out.println(nextNumberPredictor.solution(new int[]{2, -2, 2, -2}));
    }
    public int solution(int[] common) {
        int last = common[common.length-1];

        int gap1 = common[1] - common[0];
        int gap2 = common[2] - common[1];

        if (gap1 == gap2){
            return last + gap1;
        } else {
            int x = gap1 < gap2? gap2/gap1 : gap1/gap2;
            return last * x;
        }
    }
}
