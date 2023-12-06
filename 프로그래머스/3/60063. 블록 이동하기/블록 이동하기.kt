class Solution {
    data class Robot(
        val r: Int,
        val c: Int,
        val direction: Int,
        val time: Int,
    )

    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val visited = Array(n) { Array(n) { BooleanArray(2) } }
        val queue = ArrayDeque<Robot>()
        queue.add(Robot(0, 1, 1, 0))
        while (queue.isNotEmpty()) {
            val robot = queue.removeFirst()
            if (robot.r == n - 1 && robot.c == n - 1) {
                return robot.time
            }
            if (visited[robot.r][robot.c][robot.direction]) {
                continue
            }
            visited[robot.r][robot.c][robot.direction] = true
            moveRobot(board, visited, robot, queue)
        }
        return -1
    }

    private fun moveRobot(
        board: Array<IntArray>,
        visited: Array<Array<BooleanArray>>,
        robot: Robot,
        queue: ArrayDeque<Robot>,
    ) {
        val dx = intArrayOf(0, 0, 1, -1)
        val dy = intArrayOf(1, -1, 0, 0)
        val n = board.size
        val (r, c, direction, time) = robot
        val r2 = if (direction == 0) r - 1 else r
        val c2 = if (direction == 1) c - 1 else c
        for (i in 0 until 4) {
            val nr = r + dx[i]
            val nc = c + dy[i]
            val nr2 = r2 + dx[i]
            val nc2 = c2 + dy[i]
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || nr2 < 0 || nr2 >= n || nc2 < 0 || nc2 >= n) {
                continue
            }
            if (board[nr][nc] == 1 || board[nr2][nc2] == 1) {
                continue
            }
            if (visited[nr][nc][direction]) {
                continue
            }
            queue.add(Robot(nr, nc, direction, time + 1))
        }
        if (direction == 0) {
            if (c - 1 >= 0 && board[r - 1][c - 1] == 0 && board[r][c - 1] == 0) {
                if (!visited[r - 1][c][1]) queue.add(Robot(r - 1, c, 1, time + 1))
                if (!visited[r][c][1]) queue.add(Robot(r, c, 1, time + 1))
            }
            if (c + 1 < n && board[r - 1][c + 1] == 0 && board[r][c + 1] == 0) {
                if (!visited[r - 1][c + 1][1]) queue.add(Robot(r - 1, c + 1, 1, time + 1))
                if (!visited[r][c + 1][1]) queue.add(Robot(r, c + 1, 1, time + 1))
            }
        } else {
            if (r - 1 >= 0 && board[r - 1][c - 1] == 0 && board[r - 1][c] == 0) {
                if (!visited[r][c - 1][0]) queue.add(Robot(r, c - 1, 0, time + 1))
                if (!visited[r][c][0]) queue.add(Robot(r, c, 0, time + 1))
            }
            if (r + 1 < n && board[r + 1][c - 1] == 0 && board[r + 1][c] == 0) {
                if (!visited[r + 1][c - 1][0]) queue.add(Robot(r + 1, c - 1, 0, time + 1))
                if (!visited[r + 1][c][0]) queue.add(Robot(r + 1, c, 0, time + 1))
            }
        }
    }
}