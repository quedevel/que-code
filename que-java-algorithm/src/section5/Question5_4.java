package section5;

import java.util.Scanner;
import java.util.function.BinaryOperator;

/**
 * 05-04
 * 4. 후위식 연산(postfix)
 */
public class Question5_4 {
    enum Operator implements BinaryOperator<Integer> {

        PLUS('+'){
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1+n2;
            }
        },
        MINUS('-'){
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1-n2;
            }
        },
        TIMES('*'){
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1*n2;
            }
        },
        DIVISION('-'){
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1/n2;
            }
        }
        ;

        char operator;

        Operator(char operator) {
            this.operator = operator;
        }

        public static Operator fromChar(char operator) {
            for (Operator op : Operator.values()) {
                if (op.operator == operator) return op;
            }
            throw new IllegalArgumentException("Received a fishy operator: " + operator);
        }
    }
    public static void solution(String postFix){
        Integer apply = Operator.PLUS.apply(1, 2);
        System.out.println("apply = " + apply);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String postFix = sc.nextLine();
        solution(postFix);
    }
}