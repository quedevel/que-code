package programmers.level1;

public class CardDeck {
    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();
        System.out.println(cardDeck.solution(new String[]{"i","water","drink"}, new String[]{"want","to"}, new String[]{"i","want","to","drink","water"}));
    }
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < goal.length; i++) {
            if (index1 <= cards1.length-1 && goal[i].equals(cards1[index1])){
                index1++;
            } else if (index2 <= cards2.length-1 && goal[i].equals(cards2[index2])){
                index2++;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
