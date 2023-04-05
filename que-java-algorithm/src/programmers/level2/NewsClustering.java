package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsClustering {
    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        System.out.println(newsClustering.solution("FRANCE","french"));
        System.out.println(newsClustering.solution("handshake","shake hands"));
        System.out.println(newsClustering.solution("aa1+aa2","AAAA12"));
        System.out.println(newsClustering.solution("E=M*C^2","e=m*c^2"));
    }
    public int solution(String str1, String str2) {
        final int M = 65536;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.equals(str2)) return M;
        String[] str1Arr = str1.split("");
        String[] str2Arr = str2.split("");

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1Arr.length - 1; i++) {
            String temp = str1Arr[i] + str1Arr[i+1];
            if(temp.matches("[a-z]*")){
                list1.add(temp);
            }
        }
        for (int i = 0; i < str2Arr.length - 1; i++) {
            String temp = str2Arr[i] + str2Arr[i+1];
            if(temp.matches("[a-z]*")){
                list2.add(temp);
            }
        }

        // 다중집합 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합과 합집합 구하기
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        for (String s : list1) {
            if (list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : list2) {
            union.add(s);
        }

        // 자카드 유사도 계산
        double jaccardSimilarity = 0.0;
        if (union.size() == 0) { // 합집합이 공집합인 경우
            jaccardSimilarity = 1.0;
        } else {
            jaccardSimilarity = (double) intersection.size() / union.size();
        }

        int answer = (int) (jaccardSimilarity * M);
        return answer;
    }
}
