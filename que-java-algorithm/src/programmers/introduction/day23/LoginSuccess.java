package programmers.introduction.day23;

import java.util.HashMap;
import java.util.Map;

public class LoginSuccess {
    public static void main(String[] args) {
        LoginSuccess loginSuccess = new LoginSuccess();
        System.out.println(loginSuccess.solution(new String[]{"meosseugi", "1234"},new String[][]{{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}));
        System.out.println(loginSuccess.solution(new String[]{"programmer01", "15789"},new String[][]{{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}}));
        System.out.println(loginSuccess.solution(new String[]{"rabbit04", "98761"},new String[][]{{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}}));
    }
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];

        Map<String,String> dbMap = new HashMap<>();

        for (int i = 0; i < db.length; i++) {
            dbMap.put(db[i][0], db[i][1]);
        }

        if (dbMap.containsKey(id)){
            if (dbMap.get(id).equals(pw)){
                return "login";
            } else {
                return "wrong pw";
            }
        } else {
            return "fail";
        }
    }
}
