import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        var maxAlpReq = 0
        var maxCopReq = 0
        problems.forEach {
            maxAlpReq = max(maxAlpReq, it[0])
            maxCopReq = max(maxCopReq, it[1])
        }
        val dp = Array(maxAlpReq + 1) { IntArray(maxCopReq + 1) { Int.MAX_VALUE } }
        val minAlp = min(alp, maxAlpReq)
        val minCop = min(cop, maxCopReq)
        dp[minAlp][minCop] = 0
        for (i in minAlp..maxAlpReq) {
            for (j in minCop..maxCopReq) {
                if (i < maxAlpReq)
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)
                if (j < maxCopReq)
                    dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1)
                problems.forEach { problem ->
                    val alpReq = problem[0]
                    val copReq = problem[1]
                    val alpRwd = problem[2]
                    val copRwd = problem[3]
                    val cost = problem[4]
                    if (i >= alpReq && j >= copReq) {
                        val newAlp = min(i + alpRwd, maxAlpReq)
                        val newCop = min(j + copRwd, maxCopReq)
                        dp[newAlp][newCop] = min(dp[newAlp][newCop], dp[i][j] + cost)
                    }
                }
            }
        }
        return dp[maxAlpReq][maxCopReq]
    }
}