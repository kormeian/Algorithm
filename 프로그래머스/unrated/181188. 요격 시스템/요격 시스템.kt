class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }
        var answer: Int = 0
        var cur = -1
        targets.forEach {
            if (cur <= it[0]) {
                answer++
                cur = it[1]
            }
        }
        return answer
    }
}