class Solution {
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8);
    }
    public static void dfs(int[] map, int row) {
        if (row == N) { 
            answer++;
        } else {
            for (int col = 1; col <= N; col++) {
                map[row + 1] = col;
                if (check(map, row + 1)) {
                    dfs(map, row+1);
                }
            }
        }
    }

    public static boolean check(int[] map, int row) {
        for (int i = 1; i < row; i++) { 
            if (map[i] == map[row]) {
                return false;
            }
            if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        N = n;
        for (int i = 1; i <= n; i++) {
            int[] map = new int[n + 1];
            map[1] = i;
            dfs(map, 1);
        }
        return answer;
    }
}