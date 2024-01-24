class Solution {
    fun solution(maps: Array<String>): Int {
        val n = maps.size
        val m = maps[0].length
        val visited = Array(n) { BooleanArray(m) }
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        var lever = Pair(-1, -1)
        var exit = Pair(-1, -1)
        var start = Pair(-1, -1)

        for (i in 0 until n) {
            for (j in 0 until m) {
                when (maps[i][j]) {
                    'S' -> start = Pair(i, j)
                    'L' -> lever = Pair(i, j)
                    'E' -> exit = Pair(i, j)
                }
            }
        }

        fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
            queue.clear()
            visited.forEach { it.fill(false) }
            queue.add(start)
            visited[start.first][start.second] = true
            var count = 0

            while (queue.isNotEmpty()) {
                val size = queue.size
                repeat(size) {
                    val cur = queue.removeFirst()
                    if (cur == end) return count
                    listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0)).forEach { (dx, dy) ->
                        val nx = cur.first + dx
                        val ny = cur.second + dy
                        if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && maps[nx][ny] != 'X') {
                            queue.add(Pair(nx, ny))
                            visited[nx][ny] = true
                        }
                    }
                }
                count++
            }
            return -1
        }

        val toLever = bfs(start, lever)
        val toExit = bfs(lever, exit)
        return if (toLever == -1 || toExit == -1) -1 else toLever + toExit
    }
}