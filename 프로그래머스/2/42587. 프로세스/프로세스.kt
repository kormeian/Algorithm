class Solution {
     fun solution(priorities: IntArray, location: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        priorities.forEachIndexed { index, priority ->
            queue.add(Pair(index, priority))
        }

        var order = 0
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (queue.any { it.second > current.second }) {
                queue.add(current)
            } else {
                order++
                if (current.first == location) {
                    return order
                }
            }
        }
        return -1
    }
}