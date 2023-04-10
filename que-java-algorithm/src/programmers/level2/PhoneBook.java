package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook.solution(new String[]{
                "119", "97674223", "1195524421"
        }));
        System.out.println(phoneBook.solution(new String[]{
                "123","456","789"
        }));
        System.out.println(phoneBook.solution(new String[]{
                "12","123","1235","567","88"
        }));
    }

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s,1);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }
        return true;
    }
}
