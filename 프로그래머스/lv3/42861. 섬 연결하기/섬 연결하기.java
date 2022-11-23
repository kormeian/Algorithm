import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (x, y) -> x[2] - y[2]);

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            visited[i] = i;
        }

        int answer = 0;
        for (int[] edge : costs) {
            int parent1 = findParent(edge[0], visited);
            int parent2 = findParent(edge[1], visited);

            if (parent1 == parent2) continue;
            answer += edge[2];
            visited[parent2] = parent1;
        }
        return answer;
    }

    public static int findParent(int edge, int[] visited) {
        if (visited[edge] == edge) return edge;
        return findParent(visited[edge],visited);
    }
}