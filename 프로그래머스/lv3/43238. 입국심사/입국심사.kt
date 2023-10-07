class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        times.sort()
        var left: Long = 0
        var right: Long = times[times.size - 1].toLong() * n
        while (left <= right) {
            val mid = (left + right) / 2
            var sum: Long = 0
            for (time in times) {
                sum += mid / time
            }
            if (sum >= n) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return answer
    }
}