import kotlin.math.abs

class Solution {
    fun solution(a: IntArray, edges: Array<IntArray>): Long {
        val size = a.size
        val graph = Array(size) { mutableListOf<Int>() }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            graph[u].add(v)
            graph[v].add(u)
        }

        val visited = BooleanArray(size)
        val weights = LongArray(size) { a[it].toLong() }
        var answer = 0L

        val stack = mutableListOf(0)
        val parent = IntArray(size) { -1 }

        while (stack.isNotEmpty()) {
            val node = stack.last()
            if (!visited[node]) {
                visited[node] = true
                for (next in graph[node]) {
                    if (!visited[next]) {
                        parent[next] = node
                        stack.add(next)
                    }
                }
            } else {
                stack.removeAt(stack.size - 1)
                if (parent[node] != -1) {
                    weights[parent[node]] += weights[node]
                    answer += abs(weights[node])
                }
            }
        }

        return if (weights[0] == 0L) answer else -1
    }
}