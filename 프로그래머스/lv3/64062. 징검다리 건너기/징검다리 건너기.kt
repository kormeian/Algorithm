import kotlin.math.max

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0
        var min = 1
        var max = 200000000
        while (min <= max) {
            val mid = (min + max) / 2
            if (isAcross(stones, k, mid)) {
                min = mid + 1
                answer = max(answer, mid)
            } else {
                max = mid - 1
            }
        }
        return answer
    }

    private fun isAcross(stones: IntArray, k: Int, max: Int): Boolean {
        var count = 0
        for (i in stones.indices) {
            if (stones[i] - max < 0) {
                count++
            } else {
                count = 0
            }
            if (count >= k) {
                return false
            }
        }
        return true
    }
}