import kotlin.math.abs

class Solution {
    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun solution(n: Int, wires: Array<IntArray>): Int {
        graph = Array(n + 1) { mutableListOf<Int>() }
        for (wire in wires) {
            graph[wire[0]].add(wire[1])
            graph[wire[1]].add(wire[0])
        }

        var answer = n
        for (wire in wires) {
            visited = BooleanArray(n + 1)
            val count1 = dfs(wire[0], wire[1])
            val count2 = n - count1
            answer = minOf(answer, abs(count1 - count2))
        }
        return answer
    }

    private fun dfs(node: Int, except: Int): Int {
        visited[node] = true
        var count = 1

        for (next in graph[node]) {
            if (!visited[next] && next != except) {
                count += dfs(next, except)
            }
        }
        return count
    }
}