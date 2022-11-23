import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<String, Integer>();
		for (String record : records) {
			StringTokenizer st = new StringTokenizer(record, " ");
			StringTokenizer timeToken = new StringTokenizer(st.nextToken(), ":");
			int minute = Integer.parseInt(timeToken.nextToken()) * 60 + Integer.parseInt(
				timeToken.nextToken());
			String carNum = st.nextToken();
			if (st.nextToken().equals("IN")) {
				map.put(carNum, map.getOrDefault(carNum, 0) - minute);
			} else {
				map.put(carNum, map.getOrDefault(carNum, 0) + minute);
			}
		}
		PriorityQueue<String> queue = new PriorityQueue<String>();
		for (String s : map.keySet()) {
			if (map.get(s) <= 0) {
				map.put(s, map.getOrDefault(s, 0) + 1439);
			}
			queue.add(s);
		}
		int[] answer = new int[queue.size()];
		for (int i = 0; i < answer.length; i++) {
			int curMinute = map.get(queue.poll());
			if (curMinute <= fees[0]) {
				answer[i] = fees[1];
			} else {
				answer[i] = (int) (fees[1]
					+ Math.ceil((double) (curMinute - fees[0]) / fees[2]) * fees[3]);
			}
		}
		return answer;
    }
}