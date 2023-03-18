package programmers.level1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SmallSubstringFinder {
    public static void main(String[] args) {
        SmallSubstringFinder smallSubstringFinder = new SmallSubstringFinder();
        System.out.println(smallSubstringFinder.solution("3141592","271"));
        System.out.println(smallSubstringFinder.solution("500220839878","7"));
        System.out.println(smallSubstringFinder.solution("10203","15"));
    }
    public int solution(String t, String p) {
        BigInteger valueOfP = BigInteger.valueOf(Long.parseLong(p));
        List<BigInteger> list = new ArrayList<>();
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String substring = t.substring(i, i+p.length());
            BigInteger valueOf = BigInteger.valueOf(Long.parseLong(substring));
            if (valueOf.compareTo(valueOfP) != 1){
                list.add(valueOf);
            }
        }
        return list.size();
    }

}
