class Solution {
    private var visited: Array<BooleanArray> = arrayOf()
    private val dx = arrayOf(0, 0, 1, -1)
    private val dy = arrayOf(1, -1, 0, 0)
    
    fun solution(maps: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        visited = Array(maps.size) { BooleanArray(maps[0].length) { false } }
        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] == 'X') continue
                if (visited[i][j]) continue
                answer.add(bfs(i, j, maps))
            }
        }
        return if (answer.isEmpty()) intArrayOf(-1) else answer.toIntArray().sortedArray()
    }

    private fun bfs(x: Int, y: Int, maps: Array<String>): Int {
        val queue = mutableListOf<Pair<Int, Int>>()
        var count = maps[x][y].toString().toInt()
        queue.add(Pair(x, y))
        visited[x][y] = true
        while (queue.isNotEmpty()) {
            val (curX, curY) = queue.removeAt(0)
            for (i in 0 until 4) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if (nx < 0 || nx >= maps.size || ny < 0 || ny >= maps[0].length) continue
                if (maps[nx][ny] == 'X') continue
                if (visited[nx][ny]) continue
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
                count += maps[nx][ny].toString().toInt()
            }
        }
        return count
    }
}