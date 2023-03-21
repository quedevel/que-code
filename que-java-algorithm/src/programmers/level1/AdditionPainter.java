package programmers.level1;

public class AdditionPainter {
    public static void main(String[] args) {
        AdditionPainter additionPainter = new AdditionPainter();
        System.out.println(additionPainter.solution(8,4,new int[]{2,3,6}));
        System.out.println(additionPainter.solution(5,4,new int[]{1,3}));
        System.out.println(additionPainter.solution(4,1,new int[]{1,2,3,4}));
    }
    public int solution(int n, int m, int[] section) {
        if (m == 1) return section.length;

        boolean[] except = new boolean[n];
        for (int i = 0; i < section.length; i++) {
            except[section[i]-1] = true;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (except[i]){
                for (int j = i; j < i + m; j++) {
                    if (j > n-1) break;
                    except[j] = false;
                }
                answer++;
            }
        }

        return answer;
    }
}
