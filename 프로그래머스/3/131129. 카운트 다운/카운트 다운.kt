import kotlin.math.max

class Solution {
    fun solution(target: Int): IntArray {
        val dp = IntArray(target + 1) { Int.MAX_VALUE }
        val singles = IntArray(target + 1)
        dp[0] = 0

        for (score in 1..target) {
            for (dartValue in 1..20) {
                for (multiplier in 1..3) {
                    val totalDartValue = dartValue * multiplier
                    if (totalDartValue <= score) {
                        if (dp[score] > dp[score - totalDartValue] + 1) {
                            dp[score] = dp[score - totalDartValue] + 1
                            singles[score] = singles[score - totalDartValue] + if (multiplier == 1) 1 else 0
                        } else if (dp[score] == dp[score - totalDartValue] + 1) {
                            singles[score] =
                                max(singles[score], singles[score - totalDartValue] + if (multiplier == 1) 1 else 0)
                        }
                    }
                }
            }
            if (score >= 50) {
                if (dp[score] > dp[score - 50] + 1) {
                    dp[score] = dp[score - 50] + 1
                    singles[score] = singles[score - 50] + 1
                } else if (dp[score] == dp[score - 50] + 1) {
                    singles[score] = max(singles[score], singles[score - 50] + 1)
                }
            }
        }

        return intArrayOf(dp[target], singles[target])
    }
}