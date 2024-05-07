class Solution {
    fun solution(n: Int, edges: Array<IntArray>): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()

        for (edge in edges) {
            map.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            map.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        val start = dfs(1, n, map)
        val end = dfs(start.first, n, map)
        if (end.third == 0) {
            return end.second
        }

        val result = dfs(end.first, n, map)
        return result.second - result.third
    }

    private fun dfs(start: Int, n: Int, map: Map<Int, List<Int>>): Triple<Int, Int, Int> {
        val stack = ArrayDeque<Pair<Int, Int>>()
        val visited = BooleanArray(n + 1) { false }
        stack.add(Pair(start, 0))
        visited[start] = true
        var maxNode = start
        var maxDist = 0
        var maxCheck = 1

        while (stack.isNotEmpty()) {
            val (node, dist) = stack.removeLast()
            if (dist > maxDist) {
                maxNode = node
                maxDist = dist
                maxCheck = 1
            } else if (dist == maxDist) {
                maxCheck = 0
            }

            for (next in map[node] ?: emptyList()) {
                if (!visited[next]) {
                    visited[next] = true
                    stack.add(Pair(next, dist + 1))
                }
            }
        }

        return Triple(maxNode, maxDist, maxCheck)
    }
}