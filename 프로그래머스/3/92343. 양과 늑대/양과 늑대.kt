class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        var answer: Int = 0
        val visited = BooleanArray(info.size)
        fun dfs(sheep: Int, wolf: Int) {
            if (sheep > wolf) {
                answer = answer.coerceAtLeast(sheep)
            } else {
                return
            }
            edges.forEach {
                if (visited[it[0]] && !visited[it[1]]) {
                    visited[it[1]] = true
                    if (info[it[1]] == 0) {
                        dfs(sheep + 1, wolf)
                    } else {
                        dfs(sheep, wolf + 1)
                    }
                    visited[it[1]] = false
                }
            }
        }
        visited[0] = true
        dfs(1, 0)
        return answer
    }
}