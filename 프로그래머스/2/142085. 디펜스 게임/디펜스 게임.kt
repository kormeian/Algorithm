import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 1
        var soldier = n
        var card = k
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        enemy.forEach {
            pq.add(it)
            soldier -= it
            while (pq.isNotEmpty() && soldier < 0 && card > 0) {
                soldier += pq.poll()
                card--
            }
            if (soldier < 0) {
                return answer - 1
            }
            answer++
        }
        return enemy.size
    }
}