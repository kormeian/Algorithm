class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val dp = IntArray(y + 1)
        for (i in x..y) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1
                continue
            }
            if (i * 2 <= y) {
                dp[i * 2] = if (dp[i * 2] == 0) dp[i] + 1 else minOf(dp[i * 2], dp[i] + 1)
            }
            if (i * 3 <= y) {
                dp[i * 3] = if (dp[i * 3] == 0) dp[i] + 1 else minOf(dp[i * 3], dp[i] + 1)
            }
            if (i + n <= y) {
                dp[i + n] = if (dp[i + n] == 0) dp[i] + 1 else minOf(dp[i + n], dp[i] + 1)
            }
        }
        return dp[y]
    }
}