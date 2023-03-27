package programmers.level1;

    import java.util.*;

public class PersonalDataExpiration {
    public static void main(String[] args) {
        PersonalDataExpiration personalDataExpiration = new PersonalDataExpiration();
        System.out.println(
                    personalDataExpiration.solution(
                            "2022.05.19",
                            new String[]{"A 6", "B 12", "C 3"},
                            new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})
        );
        System.out.println(
                    personalDataExpiration.solution(
                            "2020.01.01",
                            new String[]{"Z 3", "D 5"},
                            new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"})
        );
    }

    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        for (String value : terms) {
            String[] term = value.split(" ");
            termsMap.put(term[0], Integer.valueOf(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int expiration = termsMap.get(s[1]);

            String[] date = s[0].split("\\.");
            int month = Integer.parseInt(date[1]);

            int expired = month + expiration;
            date[0] = (Integer.parseInt(date[0])+(expired%12==0? (expired/12)-1: expired/12))+"";

            expired %= 12;
            if (expired == 0) expired = 12;
            date[1] = expired < 10? "0"+expired : expired+"";

            if (afterToday(today, date)){
                result.add(i+1);
            }
        }
        return result;
    }

    private static boolean afterToday(String today, String[] date){
        String todayStr = today.replaceAll("\\.", "");
        String dateStr = String.join("",date);
        return Integer.parseInt(todayStr) >= Integer.parseInt(dateStr);
    }
}
