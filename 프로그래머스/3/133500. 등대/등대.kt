class Solution {
    private var answer: Int = 0
    private lateinit var visited: BooleanArray
    fun solution(n: Int, lighthouse: Array<IntArray>): Int {
        visited = BooleanArray(n + 1)
        val map = Array(n + 1) { mutableListOf<Int>() }
        lighthouse.forEach {
            map[it[0]].add(it[1])
            map[it[1]].add(it[0])
        }
        dfs(1, 1, map)
        return answer
    }

    private fun dfs(node: Int, parent: Int, map: Array<MutableList<Int>>) {
        for (i in 0 until map[node].size) {
            if (map[node][i] != parent) {
                dfs(map[node][i], node, map)
                if (!visited[map[node][i]] && !visited[node]) {
                    visited[node] = true
                    answer++
                }
            }
        }
    }
}