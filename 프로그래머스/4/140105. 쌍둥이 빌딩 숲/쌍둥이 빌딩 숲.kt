class Solution {
    private val mod = 1_000_000_007

    fun solution(n: Int, count: Int): Int {
        val dp = Array(n + 1) { LongArray(n + 1) }
        dp[1][1] = 1

        for (i in 2..n) {
            for (j in 1..i) {
                dp[i][j] =
                    (dp[i - 1][j] * (i - 1) * 2 + dp[i - 1][j - 1]) % mod
            }
        }
        return dp[n][count].toInt()
    }
}