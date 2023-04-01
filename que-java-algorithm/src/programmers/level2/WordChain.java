package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;

public class WordChain {
    public static void main(String[] args) {
        WordChain wordChain = new WordChain();
        System.out.println(Arrays.toString(wordChain.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(wordChain.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(wordChain.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>();
        String before = "";
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]) || !isExactWord(before, words[i])){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            } else {
                map.put(words[i], 1);
                before = words[i];
            }
        }
        return answer;
    }

    private static boolean isExactWord(String before, String current){
        if (before.isEmpty()) return true;
        return before.charAt(before.length()-1) == current.charAt(0);
    }
}
