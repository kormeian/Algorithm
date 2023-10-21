import kotlin.math.min

class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0
        val leftMin = IntArray(a.size)
        val rightMin = IntArray(a.size)
        leftMin[0] = a[0]
        rightMin[a.size - 1] = a[a.size - 1]
        for (i in 1 until a.size) {
            leftMin[i] = min(leftMin[i - 1], a[i])
        }
        for (i in a.size - 2 downTo 0) {
            rightMin[i] = min(rightMin[i + 1], a[i])
        }
        for (i in a.indices) {
            if (i == 0 || i == a.size - 1) {
                answer++
                continue
            }
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                answer++
            }
        }
        return answer
    }
}