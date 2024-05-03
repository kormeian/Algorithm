class Solution {
    fun solution(temperature: Int, t1: Int, t2: Int, a: Int, b: Int, onboard: IntArray): Int {
        var temp = if (temperature > t2) t1 - (temperature - t2) else temperature
        val INF = 1000 * 100
        val t1Temp = t1 - temp
        val t2Temp = t2 - temp
        temp = 0

        val dp = Array(onboard.size) { IntArray(t2Temp + 2) { INF } }
        dp[0][0] = 0
        for (i in 1 until onboard.size) {
            for (j in 0..t2Temp + 1) {
                if (onboard[i] == 1 && (j < t1Temp || j > t2Temp)) continue
                var min = INF
                if (j == 0) {
                    min = minOf(min, dp[i - 1][j])
                    if (j + 1 <= t2Temp + 1) min = minOf(min, dp[i - 1][j + 1])
                } else {
                    if (j - 1 >= 0) min = minOf(min, dp[i - 1][j - 1] + a)
                    min = minOf(min, dp[i - 1][j] + b)
                    if (j + 1 <= t2Temp + 1) min = minOf(min, dp[i - 1][j + 1])
                }
                dp[i][j] = min
            }
        }

        return dp[onboard.size - 1].minOrNull() ?: INF
    }
}