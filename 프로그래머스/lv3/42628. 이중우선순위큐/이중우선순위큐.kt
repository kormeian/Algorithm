import java.util.*
class Solution {
    fun solution(operations: Array<String>): IntArray {
        val answer = intArrayOf(0,0)
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        operations.forEach {
            val (op, num) = it.split(" ")
            if (op == "I") {
                minHeap.add(num.toInt())
                maxHeap.add(num.toInt())
            } else {
                if (minHeap.isEmpty()) return@forEach
                if (num == "1") {
                    val max = maxHeap.poll()
                    minHeap.remove(max)
                } else {
                    val min = minHeap.poll()
                    maxHeap.remove(min)
                }
            }
        }
        if (minHeap.isNotEmpty()) {
            answer[0] = maxHeap.poll()
            answer[1] = minHeap.poll()
        }
        return answer
    }
}