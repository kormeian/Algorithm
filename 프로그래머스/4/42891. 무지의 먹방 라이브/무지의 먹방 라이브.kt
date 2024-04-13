import java.util.*

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        var k = k
        val queue: Queue<Pair<Int, Int>> = PriorityQueue(compareBy { it.first })
        for (i in food_times.indices) {
            queue.add(Pair(food_times[i], i + 1))
        }
        var sum = 0L
        var previous = 0
        var length = food_times.size
        while (sum + (queue.peek().first - previous).toLong() * length <= k) {
            val now = queue.poll().first
            sum += (now - previous).toLong() * length
            length -= 1
            previous = now
            if (queue.isEmpty()) {
                return -1
            }
        }
        val result = queue.sortedWith(compareBy { it.second }).toList()
        return result[((k - sum) % length).toInt()].second
    }
}