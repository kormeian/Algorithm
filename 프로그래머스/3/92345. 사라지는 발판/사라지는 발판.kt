class Solution {
    private val dy = intArrayOf(-1, 1, 0, 0)
    private val dx = intArrayOf(0, 0, -1, 1)

    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        return play(board, aloc[0], aloc[1], bloc[0], bloc[1]).turn
    }

    data class Result(val canWin: Int, val turn: Int)

    private fun play(board: Array<IntArray>, y1: Int, x1: Int, y2: Int, x2: Int): Result {
        if (board.isFinished(y1, x1, dy, dx)) {
            return Result(0, 0)
        }

        if (y1 == y2 && x1 == x2) {
            return Result(1, 1)
        }

        var minTurn = Int.MAX_VALUE
        var maxTurn = 0
        var canWin = false

        for (i in 0 until 4) {
            val ny = y1 + dy[i]
            val nx = x1 + dx[i]
            if (!board.inRange(ny, nx) || board[ny][nx] == 0) {
                continue
            }

            board[y1][x1] = 0
            val result = play(board, y2, x2, ny, nx)
            board[y1][x1] = 1

            if (result.canWin == 0) {
                canWin = true
                minTurn = minOf(minTurn, result.turn)
            } else if (!canWin) {
                maxTurn = maxOf(maxTurn, result.turn)
            }
        }

        val turn = if (canWin) minTurn else maxTurn

        return Result(if (canWin) 1 else 0, turn + 1)
    }

    private fun Array<IntArray>.isFinished(y: Int, x: Int, dy: IntArray, dx: IntArray): Boolean {
        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (this.inRange(ny, nx) && this[ny][nx] == 1) {
                return false
            }
        }
        return true
    }

    private fun Array<IntArray>.inRange(y: Int, x: Int): Boolean {
        return y in this.indices && x in this[0].indices
    }
}