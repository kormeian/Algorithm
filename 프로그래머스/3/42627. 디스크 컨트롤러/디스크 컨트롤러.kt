import java.util.*
class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var idx = 0
        var time = 0
        var count = 0
        val pq = PriorityQueue<IntArray>(compareBy { it[1] })
        jobs.sortBy { it[0] }
        while (count < jobs.size) {
            while (idx < jobs.size && jobs[idx][0] <= time) {
                pq.add(jobs[idx++])
            }
            if (pq.isEmpty()) {
                time = jobs[idx][0]
            } else {
                val job = pq.poll()
                answer += time - job[0] + job[1]
                time += job[1]
                count++
            }
        }
        return answer / count
    }
}