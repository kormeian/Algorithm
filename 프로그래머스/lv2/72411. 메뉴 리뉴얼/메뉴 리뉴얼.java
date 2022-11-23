import java.util.*;

class Solution {
    static int max;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < course.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            max = 0;
            for (int j = 0; j < orders.length; j++) {
                char[] order = orders[j].toCharArray();
                Arrays.sort(order);
                recur(order, course[i], "", 0, map);
            }
            for (String s : map.keySet()) {
                if (map.get(s) == max && max > 1) {
                    pq.offer(s);
                }
            }
        }
        String[] answer = new String[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }

    static void recur(char[] order, int course, String curStr,
                      int curIdx, HashMap<String, Integer> map) {
        if (curStr.length() == course) {
            map.put(curStr, map.getOrDefault(curStr, 0) + 1);
            max = Math.max(max, map.get(curStr));
            return;
        }
        for (int i = curIdx; i < order.length; i++) {
            recur(order, course, curStr + order[i], i + 1, map);
        }
    }
}