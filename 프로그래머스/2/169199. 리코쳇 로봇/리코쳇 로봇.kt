class Solution {
    private class Node(val r: Int, val c: Int, val cnt: Int)

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun solution(board: Array<String>): Int {
        val queue = ArrayDeque<Node>()
        val visited = Array(board.size) { BooleanArray(board[0].length) }
        val robot = findRobot(board)
        queue.add(robot)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (board[current.r][current.c] == 'G') {
                return current.cnt
            } else if (visited[current.r][current.c]) {
                continue
            } else {
                visited[current.r][current.c] = true
                for (direction in directions) {
                    val next = move(board, current, direction)
                    queue.add(next)
                }
            }
        }
        return -1
    }

    private fun findRobot(board: Array<String>): Node {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 'R') {
                    return Node(i, j, 0)
                }
            }
        }
        return Node(0, 0, 0)
    }

    private fun move(board: Array<String>, node: Node, direction: IntArray): Node {
        var r = node.r
        var c = node.c
        while (true) {
            r += direction[0]
            c += direction[1]
            if (r < 0 || r >= board.size || c < 0 || c >= board[0].length || board[r][c] == 'D') {
                r -= direction[0]
                c -= direction[1]
                break
            }
        }
        return Node(r, c, node.cnt + 1)
    }
}