class Solution {
    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var order: IntArray
    private lateinit var visited: BooleanArray
    private lateinit var waiting: BooleanArray

    fun solution(n: Int, path: Array<IntArray>, order: Array<IntArray>): Boolean {
        graph = Array(n) { mutableListOf<Int>() }
        this.order = IntArray(n) { -1 }
        visited = BooleanArray(n)
        waiting = BooleanArray(n)

        for (i in path.indices) {
            val a = path[i][0]
            val b = path[i][1]
            graph[a].add(b)
            graph[b].add(a)
        }

        for (i in order.indices) {
            val a = order[i][0]
            val b = order[i][1]
            this.order[b] = a
            if (a == 0) {
                this.order[a] = -1
            }
            if (b == 0) {
                return false
            }
        }

        if (!dfs(0)) {
            return false
        }

        for (i in visited.indices) {
            if (!visited[i]) {
                return false
            }
        }

        return true
    }

    private fun dfs(node: Int): Boolean {
        if (visited[node]) {
            return false
        }
        if (order[node] != -1 && !visited[order[node]]) {
            waiting[order[node]] = true
            return false
        }

        visited[node] = true

        if (waiting[node]) {
            waiting[node] = false
            dfs(order.indexOf(node))
        }

        for (next in graph[node]) {
            dfs(next)
        }

        return true
    }
}