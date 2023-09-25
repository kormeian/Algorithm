import kotlin.math.max

class Solution {
    var answer = 0
    var visited: Array<Boolean> = arrayOf()
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = Array(dungeons.size) { false }
        dfs(0, k, dungeons)
        return answer
    }

    fun dfs(
        depth: Int,
        k: Int,
        dungeons: Array<IntArray>
    ) {
        for (i in 0 until dungeons.size) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true
                dfs(depth + 1, k - dungeons[i][1], dungeons)
                visited[i] = false
            }
        }
        answer = max(answer, depth)
    }
}