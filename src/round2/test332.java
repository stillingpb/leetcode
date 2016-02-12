package round2;


import java.util.*;

/**
 * 构建欧拉回路，这道题的数据结构设计完美，结合巧妙的构造过程，能够简洁的实现欧拉回路的构建.
 */
public class test332 {
    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<String> ans = new test332().findItinerary(tickets);
        System.out.println(ans);

        tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        ans = new test332().findItinerary(tickets);
        System.out.println(ans);

        tickets = new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        ans = new test332().findItinerary(tickets);
        System.out.println(ans);

        tickets = new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}, {"JFK", "AAA"}, {"AAA", "JFK"}};
        ans = new test332().findItinerary(tickets);
        System.out.println(ans);
    }

    Map<String, PriorityQueue<String>> targets;
    List<String> ans;

    public List<String> findItinerary(String[][] tickets) {
        targets = new HashMap<>();
        for (String[] route : tickets) {
            PriorityQueue<String> queue = targets.get(route[0]);
            if (queue == null) {
                queue = new PriorityQueue<>();
                targets.put(route[0], queue);
            }
            queue.offer(route[1]);
        }
        ans = new LinkedList<>();
        dfs("JFK");
        return ans;
    }

    private void dfs(String airport) {
        PriorityQueue<String> nexts = targets.get(airport);
        if (nexts != null) {
            while (!nexts.isEmpty()) {
                dfs(nexts.poll());
            }
        }
        ans.add(0, airport);
    }
}
