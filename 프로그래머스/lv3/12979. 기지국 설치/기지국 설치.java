class Solution {
    public int solution(int n, int[] stations, int w) {
        int stationIdx = 0;
        int curIdx = 1;
        int answer = 0;
        while (curIdx <= n) {
            if (stationIdx < stations.length && curIdx >= stations[stationIdx] - w) {
                curIdx = stations[stationIdx] + w + 1;
                stationIdx++;
            } else {
                curIdx += 2 * w + 1;
                answer += 1;
            }
        }
        return answer;
    }
}