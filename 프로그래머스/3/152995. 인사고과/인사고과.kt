class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 1
        val target = scores[0]
        val targetScoreSum = target.sum()
        scores.sortWith { a, b ->
            if (a[0] == b[0]) {
                a[1] - b[1]
            } else {
                b[0] - a[0]
            }
        }
        var prev = scores[0][1]
        scores.forEach {
            if (target[0] < it[0] && target[1] < it[1]) {
                return -1
            }
            if (it[1] >= prev && targetScoreSum < it.sum()) {
                answer++
                prev = it[1]
            }
        }
        return answer
    }
}