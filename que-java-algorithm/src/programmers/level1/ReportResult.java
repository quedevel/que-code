package programmers.level1;


import java.util.*;

public class ReportResult {
    public static void main(String[] args) {
        ReportResult reportResult = new ReportResult();
        System.out.println(Arrays.toString(reportResult.solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2)));
        System.out.println(Arrays.toString(reportResult.solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3)));
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 신고 검사
        Set<String> set = new HashSet<>();
        for (String re : report) {
            set.add(re);
        }

        // 유저별 신고한 유저들
        Map<String, List<String>> reportedByUser = new HashMap<>();
        // 유저별 신고당한 횟수
        Map<String, Integer> numberOfReports = new HashMap<>();
        // 신고 누적으로 정지된 유저들
        Set<String> suspended = new HashSet<>();

        for (String re : set) {
            String[] split = re.split(" ");
            String reporter = split[0]; // 신고자
            String reported = split[1]; // 신고 당한자

            // 유저별 신고한 유저들
            List<String> byUserOrDefault = reportedByUser.getOrDefault(reporter, new ArrayList<>());
            byUserOrDefault.add(reported);
            reportedByUser.put(reporter, byUserOrDefault);

            // 유저별 신고당한 횟수
            int number = numberOfReports.getOrDefault(reported, 0) + 1;
            numberOfReports.put(reported, number);

            // k번 이상 경고 누적된 유저
            if (number >= k){
                suspended.add(reported);
            }
        }

        int[] answer = new int[id_list.length];

        // k번 이상 경고 누적된 유저가 없다면
        if(suspended.size() == 0){
            return answer;
        }

        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i]; // 신고자
            int emailCount = 0; // 받을 이메일 수
            List<String> reportedList = reportedByUser.getOrDefault(reporter, new ArrayList<>());
            int reportedCount = reportedList.size();
            int afterRemove = 0;
            // 신고 횟수가 1회 이상부터 조사
            if (reportedCount > 0){
                reportedList.removeAll(suspended);
                afterRemove = reportedList.size();
                emailCount = reportedCount - afterRemove;
            }
            answer[i] = emailCount;
        }

        return answer;
    }
}
