class Solution {
    private val mod = 1_000_000_007
    fun solution(n: Int): Int {
        val dp = LongArray(100001)
        val sum = LongArray(3)

        dp[0] = 1
        dp[1] = 1
        dp[2] = 3
        dp[3] = 10

        if (n <= 3) {
            return dp[n].toInt()
        }

        for (i in 4..n) {
            dp[i] += dp[i - 1] + dp[i - 2] * 2 + dp[i - 3] * 5
            sum[(i - 4) % 3] = (sum[(i - 4) % 3] + dp[i - 4]) % mod
            dp[i] += (sum[0] + sum[1] + sum[2] + sum[i % 3]) * 2
            dp[i] = dp[i] % mod
        }

        return dp[n].toInt()
    }
}