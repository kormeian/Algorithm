import java.util.*
import kotlin.math.min

class Solution {
    class Node(val to: Int, val cost: Int)
    private val graph: MutableMap<Int, MutableList<Node>> = mutableMapOf()

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        fares.forEach {
            graph[it[0]]?.add(Node(it[1], it[2])) ?: run {
                graph[it[0]] = mutableListOf(Node(it[1], it[2]))
            }
            graph[it[1]]?.add(Node(it[0], it[2])) ?: run {
                graph[it[1]] = mutableListOf(Node(it[0], it[2]))
            }
        }
        val dist = dijstra(s, n, graph)
        val distA = dijstra(a, n, graph)
        val distB = dijstra(b, n, graph)
        var min = Int.MAX_VALUE
        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE || distA[i] == Int.MAX_VALUE || distB[i] == Int.MAX_VALUE) continue
            min = min(min, dist[i] + distA[i] + distB[i])
        }
        return min
    }

    fun dijstra(start: Int, n: Int, graph: Map<Int, List<Node>>): IntArray {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>(compareBy { it.cost })
        pq.add(Node(start, 0))
        dist[start] = 0
        while (pq.isNotEmpty()) {
            val cur = pq.poll()
            if (dist[cur.to] < cur.cost) continue
            graph[cur.to]?.forEach {
                val nextDist = dist[cur.to] + it.cost
                if (nextDist < dist[it.to]) {
                    dist[it.to] = nextDist
                    pq.add(Node(it.to, nextDist))
                }
            }
        }
        return dist
    }
}