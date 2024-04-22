class Solution {
    data class Block(val number: Int, val positions: MutableList<Pair<Int, Int>> = mutableListOf())

    fun solution(board: Array<IntArray>): Int {
        val blocks = mutableMapOf<Int, Block>()
        val n = board.size
        var answer = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] != 0) {
                    val number = board[i][j]
                    blocks.putIfAbsent(number, Block(number))
                    blocks[number]?.positions?.add(Pair(i, j))
                }
            }
        }

        while (true) {
            var isRemoved = false
            for (block in blocks.values) {
                if (canRemove(block, board)) {
                    removeBlock(block, board)
                    isRemoved = true
                    answer++
                    blocks.remove(block.number)
                    break
                }
            }
            if (!isRemoved) break
        }

        return answer
    }

    private fun canRemove(block: Block, board: Array<IntArray>): Boolean {
        val minX = block.positions.minOf { it.first }
        val maxX = block.positions.maxOf { it.first }
        val minY = block.positions.minOf { it.second }
        val maxY = block.positions.maxOf { it.second }

        for (i in minX..maxX) {
            for (j in minY..maxY) {
                if (Pair(i, j) !in block.positions && !isClearAbove(Pair(i, j), board)) {
                    return false
                }
            }
        }

        return true
    }

    private fun isClearAbove(position: Pair<Int, Int>, board: Array<IntArray>): Boolean {
        for (i in 0..position.first) {
            if (board[i][position.second] != 0) {
                return false
            }
        }
        return true
    }

    private fun removeBlock(block: Block, board: Array<IntArray>) {
        for (position in block.positions) {
            board[position.first][position.second] = 0
        }
    }
}