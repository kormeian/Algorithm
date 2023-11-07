class Solution {
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        var answer = dist.size + 1
        val weakSpread = IntArray(weak.size * 2)
        weak.forEachIndexed { i, v ->
            weakSpread[i] = v
            weakSpread[i + weak.size] = v + n
        }
        for (start in weak.indices) {
            for (friends in permutation(dist, dist.size)) {
                var cnt = 1
                var position = weak[start] + friends[cnt - 1]
                for (i in start until start + weak.size) {
                    if (position < weakSpread[i]) {
                        cnt++
                        if (cnt > dist.size) break
                        position = weakSpread[i] + friends[cnt - 1]
                    }
                }
                answer = answer.coerceAtMost(cnt)
            }
        }
        if (answer > dist.size) return -1
        return answer
    }

    private fun permutation(dist: IntArray, len: Int): List<IntArray> {
        val list: MutableList<IntArray> = mutableListOf()
        val visited = BooleanArray(len)
        val result = IntArray(len)
        fun dfs(depth: Int = 0) {
            if (depth == len) {
                list.add(result.clone())
                return
            }
            for (i in dist.indices) {
                if (visited[i]) continue
                result[depth] = dist[i]
                visited[i] = true
                dfs(depth + 1)
                visited[i] = false
            }
        }
        dfs()
        return list
    }
}