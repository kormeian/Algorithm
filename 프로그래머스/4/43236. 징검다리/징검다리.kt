class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        var answer = 0
        val sortedRocks = rocks.sorted()
        var left = 1
        var right = distance
        while (left <= right) {
            val mid = (left + right) / 2
            var prev = 0
            var count = 0
            for (rock in sortedRocks) {
                if (rock - prev < mid) {
                    count++
                } else {
                    prev = rock
                }
            }
            if (distance - prev < mid) {
                count++
            }
            if (count <= n) {
                answer = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return answer
    }
}