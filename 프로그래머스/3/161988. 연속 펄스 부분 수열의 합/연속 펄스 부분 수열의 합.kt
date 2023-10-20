import kotlin.math.min

class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = Long.MIN_VALUE
        val n = sequence.size
        var sumS1: Long = 0
        var sumS2: Long = 0
        var minS1: Long = 0
        var minS2: Long = 0
        var pulse = 1
        sequence.forEach {
            sumS1 += it * pulse
            sumS2 += it * (-pulse)

            answer = maxOf(answer, sumS1 - minS1, sumS2 - minS2)

            minS1 = min(minS1, sumS1)
            minS2 = min(minS2, sumS2)

            pulse *= -1
        }
        return answer
    }
}