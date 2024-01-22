import java.util.*
class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val INF = 500001
        val dist = IntArray(N + 1) { INF }
        val adj = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }

        for (r in road) {
            adj[r[0]].add(Pair(r[1], r[2]))
            adj[r[1]].add(Pair(r[0], r[2]))
        }

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(1, 0))
        dist[1] = 0

        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            if (cur.second > dist[cur.first]) continue
            for (next in adj[cur.first]) {
                if (dist[next.first] > dist[cur.first] + next.second) {
                    dist[next.first] = dist[cur.first] + next.second
                    pq.add(Pair(next.first, dist[next.first]))
                }
            }
        }

        return dist.count { it <= k }
    }
}