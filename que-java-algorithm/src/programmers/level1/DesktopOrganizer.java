package programmers.level1;

import java.util.Arrays;

public class DesktopOrganizer {
    public static void main(String[] args) {
        DesktopOrganizer desktopOrganizer = new DesktopOrganizer();
        System.out.println(Arrays.toString(desktopOrganizer.solution(new String[]{".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(desktopOrganizer.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(desktopOrganizer.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(desktopOrganizer.solution(new String[]{"..", "#."})));
    }
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for (int i = 0; i < wallpaper.length; i++) {
            String[] split = wallpaper[i].split("");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("#")){
                    if (answer[0] > i) answer[0] = i;
                    if (answer[1] > j) answer[1] = j;
                    if (answer[2] < i+1) answer[2] = i+1;
                    if (answer[3] < j+1) answer[3] = j+1;
                }
            }
        }
        return answer;
    }
}
