class Solution {
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)
    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        val reverseBoard = Array(game_board.size) { IntArray(game_board.size) }
        for (i in game_board.indices) {
            for (j in game_board.indices) {
                reverseBoard[i][j] = if (game_board[i][j] == 0) 1 else 0
            }
        }
        val blankList = findPiece(reverseBoard)
        val puzzleList = findPiece(table)

        return checkMatch(blankList, puzzleList)
    }

    private fun findPiece(board: Array<IntArray>): MutableList<Array<Array<Int>>> {
        val visited = Array(board.size) { BooleanArray(board.size) }
        val list = mutableListOf<Array<Array<Int>>>()
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, board, visited, list)
                }
            }
        }
        return list
    }

    private fun bfs(
        x: Int,
        y: Int,
        board: Array<IntArray>,
        visited: Array<BooleanArray>,
        list: MutableList<Array<Array<Int>>>,
    ) {
        val queue = mutableListOf<Pair<Int, Int>>()
        val piece = mutableListOf<Pair<Int, Int>>()
        queue.add(Pair(x, y))
        visited[x][y] = true
        piece.add(Pair(x, y))
        while (queue.isNotEmpty()) {
            val (curX, curY) = queue.removeAt(0)
            for (i in dx.indices) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if (nx in board.indices && ny in board.indices && board[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(Pair(nx, ny))
                    visited[nx][ny] = true
                    piece.add(Pair(nx, ny))
                }
            }
        }
        val minX = piece.sortedBy { it.first }.first().first
        val minY = piece.sortedBy { it.second }.first().second
        val maxX = piece.sortedBy { it.first }.last().first
        val maxY = piece.sortedBy { it.second }.last().second
        val pieceArray = Array(maxX - minX + 1) { Array(maxY - minY + 1) { 0 } }
        for (i in piece.indices) {
            val (curX, curY) = piece[i]
            pieceArray[curX - minX][curY - minY] = 1
        }
        list.add(pieceArray)
    }

    private fun rotate(piece: Array<Array<Int>>): Array<Array<Int>> {
        val rotatedPiece = Array(piece[0].size) { Array(piece.size) { 0 } }
        for (i in piece.indices) {
            for (j in piece[0].indices) {
                rotatedPiece[j][piece.size - 1 - i] = piece[i][j]
            }
        }
        return rotatedPiece
    }

    private fun checkMatch(blank: MutableList<Array<Array<Int>>>, puzzle: MutableList<Array<Array<Int>>>): Int {
        var sum = 0
        for (i in blank.indices) {
            for (j in puzzle.indices) {
                var isMatch = true
                for (k in 0..3) {
                    if (blank[i].contentDeepEquals(puzzle[j])) {
                        sum += blank[i].sumOf { it.sum() }
                        puzzle.removeAt(j)
                        isMatch = false
                        break
                    }
                    puzzle[j] = rotate(puzzle[j])
                }
                if (!isMatch) {
                    break
                }
            }
        }
        return sum
    }
}