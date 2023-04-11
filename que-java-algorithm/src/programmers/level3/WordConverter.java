package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class WordConverter {
    public static void main(String[] args) {
        WordConverter wordConverter = new WordConverter();
        System.out.println(wordConverter.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
            ));
            System.out.println(wordConverter.solution(
                    "hit",
                    "cog",
                    new String[]{"hot", "dot", "dog", "lot", "log"}
            ));
    }
    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if (node.word.equals(target)){
                return node.dept;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                if (!isConvertable(node.word, next) || isVisited[i]){
                    continue;
                }
                isVisited[i] = true;
                queue.add(new Node(next, node.dept+1));
            }
        }
        return 0;
    }

    private static class Node {
        public final String word;
        public final int dept;

        public Node(String word, int dept) {
            this.word = word;
            this.dept = dept;
        }
    }

    private static boolean isConvertable(String src, String dst){
        char[] srcArr = src.toCharArray();
        char[] dstArr = dst.toCharArray();
        int diff = 0;
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] != dstArr[i]) diff++;
        }
        return diff == 1;
    }
}
