package programmers.level3;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        TravelRoute travelRoute = new TravelRoute();
        System.out.println(Arrays.toString(travelRoute.solution(
                new String[][]{
                        {"ICN", "JFK"},
                        {"HND", "IAD"},
                        {"JFK", "HND"}
                }
        )));
        System.out.println(Arrays.toString(travelRoute.solution(
                new String[][]{
                        {"ICN", "SFO"},
                        {"ICN", "ATL"},
                        {"SFO", "ATL"},
                        {"ATL", "ICN"},
                        {"ATL", "SFO"}
                }
        )));
    }
    public String[] solution(String[][] tickets) {
        final String start = "ICN";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0])){
                Stack<Node> stack = new Stack<>();
                boolean[] isVisited = new boolean[tickets.length];
                List<String> route = new ArrayList<>();
                route.add(tickets[i][0]);
                route.add(tickets[i][1]);
                isVisited[i] = true;
                stack.push(new Node(tickets[i][1], route, isVisited));
                while(!stack.isEmpty()){
                    Node node = stack.pop();

                    if (node.route.size() == tickets.length+1){
                        String joining = String.join(",", node.route);
                        list.add(joining);
                    }

                    for (int j = 0; j < tickets.length; j++) {
                        if (node.isVisited[j]){
                            continue;
                        }
                        if (node.to.equals(tickets[j][0])){
                            List<String> strings = new ArrayList<>(node.route);
                            strings.add(tickets[j][1]);

                            boolean[] copy = new boolean[tickets.length];
                            for (int k = 0; k < tickets.length; k++) {
                                copy[k] = node.isVisited[k];
                            }
                            copy[j] = true;
                            stack.push(new Node(tickets[j][1], strings, copy));
                        }
                    }
                }
            }
        }

        Collections.sort(list);
        return list.get(0).split(",");
    }

    private static class Node {
        private final String to;

        private final List<String> route;

        private final boolean[] isVisited;

        public Node(String to, List<String> route, boolean[] isVisited) {
            this.to = to;
            this.route = route;
            this.isVisited = isVisited;
        }
    }
}
