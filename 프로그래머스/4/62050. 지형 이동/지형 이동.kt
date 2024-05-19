import kotlin.math.abs

class Solution {
    private val dx = intArrayOf(0, 0, 1, -1)
    private val dy = intArrayOf(1, -1, 0, 0)

    fun solution(land: Array<IntArray>, height: Int): Int {
        var answer = 0
        val N = land.size
        val visited = Array(N) { BooleanArray(N) }
        val queue = ArrayDeque<Pair<Int, Int>>()
        val group = Array(N) { IntArray(N) { -1 } }
        var groupCount = 0
        queue.add(0 to 0)
        visited[0][0] = true
        while (queue.isNotEmpty()) {
            val (x, y) = queue.removeFirst()
            group[x][y] = groupCount
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
                if (visited[nx][ny]) continue
                val diff = abs(land[x][y] - land[nx][ny])
                if (diff > height) continue
                visited[nx][ny] = true
                queue.add(nx to ny)
            }
            if (queue.isEmpty()) {
                for (i in 0 until N) {
                    for (j in 0 until N) {
                        if (!visited[i][j]) {
                            queue.add(i to j)
                            visited[i][j] = true
                            groupCount++
                            break
                        }
                    }
                    if (queue.isNotEmpty()) break
                }
            }
        }
        val groupSet = Array(groupCount + 1) { mutableSetOf<Int>() }
        for (i in 0 until N) {
            for (j in 0 until N) {
                groupSet[group[i][j]].add(i * N + j)
            }
        }
        val edgeList = mutableListOf<Triple<Int, Int, Int>>()
        for (i in 0 until N) {
            for (j in 0 until N) {
                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
                    if (group[i][j] == group[nx][ny]) continue
                    val diff = abs(land[i][j] - land[nx][ny])
                    edgeList.add(Triple(group[i][j], group[nx][ny], diff))
                }
            }
        }
        edgeList.sortBy { it.third }
        val parent = IntArray(groupCount + 1) { it }
        fun find(x: Int): Int {
            if (parent[x] == x) return x
            parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            if (px < py) parent[py] = px
            else parent[px] = py
        }
        for ((a, b, c) in edgeList) {
            if (find(a) != find(b)) {
                union(a, b)
                answer += c
            }
        }
        return answer
    }
}