import kotlin.math.sqrt
class Solution {
     fun solution(e: Int, starts: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val dp = IntArray(e + 1)
        val dpIdx = IntArray(e + 1)

        for (i in 2..e) {
            for (j in 1 until minOf(e / i + 1, i)) {
                dp[i * j] += 2
            }
        }
        for (i in 1..sqrt(e.toDouble()).toInt()) {
            dp[i * i] += 1
        }

        var maxCount = 0
        for (i in e downTo 1) {
            if (maxCount <= dp[i]) {
                maxCount = dp[i]
                dpIdx[i] = i
            } else {
                dpIdx[i] = dpIdx[i + 1]
            }
        }

        for (i in starts) {
            answer.add(dpIdx[i])
        }

        return answer.toIntArray()
    }
}