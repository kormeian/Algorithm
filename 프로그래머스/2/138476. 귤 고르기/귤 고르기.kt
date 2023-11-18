class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        val values = tangerine.groupBy { it }.map { it.value.size }.sortedDescending()
        var sum = 0
        values.takeWhile { sum += it; answer++; sum < k }
        return answer
    }
}