import java.util.*
import kotlin.math.pow

class Solution {
    fun solution(n: Int, start: Int, end: Int, roads: Array<IntArray>, traps: IntArray): Int {
        val graph = Array(n) { mutableListOf<Triple<Int, Int, Int>>() }
        val trapIndexMap = traps.mapIndexed { index, trap -> trap - 1 to index }.toMap()
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        val visited = Array(2.0.pow(traps.size).toInt()) { BooleanArray(n) }

        roads.forEach { road ->
            val (s, e, t) = road
            graph[s - 1].add(Triple(e - 1, t, 0))
            graph[e - 1].add(Triple(s - 1, t, 1))
        }

        pq.offer(Triple(0, start - 1, 0))

        while (pq.isNotEmpty()) {
            val (curTime, curNode, curState) = pq.poll()
            if (curNode == end - 1) return curTime
            if (visited[curState][curNode]) continue
            visited[curState][curNode] = true

            for ((nextNode, nextCost, roadType) in graph[curNode]) {
                var nextState = curState
                val currentIsTrap = if (curNode in trapIndexMap) 1 else 0
                val nextIsTrap = if (nextNode in trapIndexMap) 1 else 0

                when (currentIsTrap + nextIsTrap) {
                    0 -> if (roadType == 1) continue
                    1 -> {
                        val trapNode = if (currentIsTrap == 1) curNode else nextNode
                        val isTrapActive = (curState and (1 shl trapIndexMap[trapNode]!!)) shr trapIndexMap[trapNode]!!
                        if (isTrapActive != roadType) continue
                    }

                    2 -> {
                        val currentTrapActive =
                            (curState and (1 shl trapIndexMap[curNode]!!)) shr trapIndexMap[curNode]!!
                        val nextTrapActive =
                            (curState and (1 shl trapIndexMap[nextNode]!!)) shr trapIndexMap[nextNode]!!
                        if (currentTrapActive xor nextTrapActive != roadType) continue
                    }
                }

                if (nextIsTrap == 1) {
                    nextState = curState xor (1 shl trapIndexMap[nextNode]!!)
                }

                pq.offer(Triple(curTime + nextCost, nextNode, nextState))
            }
        }
        return -1
    }
}