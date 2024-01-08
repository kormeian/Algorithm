class Solution {
    fun solution(n: Int, tops: IntArray): Int {
        val dp = Array(n + 1) { IntArray(2) { 0 } }
        dp[0][0] = 1
        for (i in 0 until n) {
            dp[i + 1][0] = if (tops[i] == 0) dp[i][0] * 2 + dp[i][1]
            else dp[i][0] * 3 + dp[i][1] * 2
            dp[i + 1][1] = dp[i][0] + dp[i][1]
            dp[i + 1][0] %= 10007
            dp[i + 1][1] %= 10007
        }
        return (dp[n][0] + dp[n][1]) % 10007
    }
}