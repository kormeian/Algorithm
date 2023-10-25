class Solution {
    private val dx = intArrayOf(0, 1, 0, -1)
    private val dy = intArrayOf(1, 0, -1, 0)

    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val cost = Array(n) { Array(n) { intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE) } }
        cost[0][0][0] = 0
        cost[0][0][1] = 0
        val queue = ArrayDeque<IntArray>()
        queue.add(intArrayOf(0, 0, 0))
        queue.add(intArrayOf(0, 0, 1))
        while (queue.isNotEmpty()) {
            val (x, y, dir) = queue.removeFirst()
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                val nc = cost[x][y][dir] + if ((dir + i) % 2 == 0) 100 else 600
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1 || nc > cost[nx][ny][i % 2]) continue
                cost[nx][ny][i % 2] = nc
                queue.add(intArrayOf(nx, ny, i % 2))
            }
        }
        return minOf(cost[n - 1][n - 1][0], cost[n - 1][n - 1][1])
    }
}