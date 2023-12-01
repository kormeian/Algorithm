import kotlin.math.max

class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        val node = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        paths.forEach {
            node[it[0]].add(Pair(it[1], it[2]))
            node[it[1]].add(Pair(it[0], it[2]))
        }
        return getMinIntensity(node, gates, summits.sortedArray())
    }

    private fun getMinIntensity(
        node: Array<MutableList<Pair<Int, Int>>>,
        gates: IntArray,
        summits: IntArray,
    ): IntArray {
        val visited = IntArray(node.size) { Int.MAX_VALUE }
        val queue = ArrayDeque<Pair<Int, Int>>()
        gates.forEach { gate ->
            queue.add(Pair(gate, 0))
            visited[gate] = 0
        }
        while (queue.isNotEmpty()) {
            val (current, intensity) = queue.removeFirst()
            if (summits.contains(current) || visited[current] < intensity) continue
            node[current].forEach { (next, nextIntensity) ->
                val maxIntensity = max(intensity, nextIntensity)
                if (visited[next] > maxIntensity && visited[next] != 0) {
                    visited[next] = maxIntensity
                    queue.add(Pair(next, maxIntensity))
                }
            }
        }
        val answer = IntArray(2) { Int.MAX_VALUE }
        summits.forEach { summit ->
            if (answer[1] > visited[summit]) {
                answer[1] = visited[summit]
                answer[0] = summit
            }
        }
        return answer
    }
}