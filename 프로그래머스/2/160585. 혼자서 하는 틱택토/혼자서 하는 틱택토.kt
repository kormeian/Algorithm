class Solution {
    fun solution(board: Array<String>): Int {
        val counts = board.flatMap { it.toList() }.groupingBy { it }.eachCount()
        val cntO = counts.getOrDefault('O', 0)
        val cntX = counts.getOrDefault('X', 0)

        if (cntO !in cntX..cntX + 1) return 0

        val isWinO = isWin(board, 'O')
        val isWinX = isWin(board, 'X')

        return when {
            isWinO && isWinX -> 0
            isWinO && cntO != cntX + 1 -> 0
            isWinX && cntO != cntX -> 0
            else -> 1
        }
    }

    private fun isWin(board: Array<String>, player: Char): Boolean {
        val winConditions = mutableListOf(
            listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)),
            listOf(Pair(0, 2), Pair(1, 1), Pair(2, 0)),
        )
        for (i in 0 until 3) {
            winConditions.add((0 until 3).map { Pair(i, it) })
            winConditions.add((0 until 3).map { Pair(it, i) })
        }
        return winConditions.any { it.all { (x, y) -> board[x][y] == player } }
    }
}