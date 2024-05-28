class Solution {
    private val orders = mutableListOf<MutableList<Int>>()
    private val dx = arrayOf(1, -1, 0, 0)
    private val dy = arrayOf(0, 0, 1, -1)

    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {
        val cardNum = board.sumOf { row -> row.count { it != 0 } } / 2
        val cards = (1..cardNum).toList()
        permutation(mutableListOf(), 0, cards)

        var answer = Int.MAX_VALUE
        for (order in orders) {
            var cnt = 0
            var pos = Pair(r, c)
            val copyBoard = board.map { it.copyOf() }.toTypedArray()

            for (card in order) {
                val (firstPos, firstCnt) = moveToTarget(pos, card, copyBoard)
                cnt += firstCnt
                copyBoard[firstPos.first][firstPos.second] = 0
                cnt += 1

                val (secondPos, secondCnt) = moveToTarget(firstPos, card, copyBoard)
                cnt += secondCnt
                copyBoard[secondPos.first][secondPos.second] = 0
                cnt += 1

                pos = secondPos
            }

            answer = minOf(answer, cnt)
        }

        return answer
    }

    private fun permutation(comb: MutableList<Int>, depth: Int, cards: List<Int>) {
        if (depth == cards.size) {
            orders.add(comb.toMutableList())
            return
        }
        for (card in cards) {
            if (!comb.contains(card)) {
                comb.add(card)
                permutation(comb, depth + 1, cards)
                comb.removeAt(comb.size - 1)
            }
        }
    }

    private fun moveToTarget(pos: Pair<Int, Int>, target: Int, board: Array<IntArray>): Pair<Pair<Int, Int>, Int> {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = Array(4) { BooleanArray(4) }
        queue.add(Triple(pos.first, pos.second, 0))
        visited[pos.first][pos.second] = true

        while (queue.isNotEmpty()) {
            val (x, y, cnt) = queue.removeFirst()

            if (board[x][y] == target) {
                return Pair(Pair(x, y), cnt)
            }

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0..3 && ny in 0..3 && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.add(Triple(nx, ny, cnt + 1))
                }
            }

            for (i in 0..3) {
                val (nx, ny) = ctrlMove(x, y, i, board)

                if ((nx != x || ny != y) && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.add(Triple(nx, ny, cnt + 1))
                }
            }
        }
        return Pair(pos, 0)
    }

    private fun ctrlMove(x: Int, y: Int, dirIdx: Int, board: Array<IntArray>): Pair<Int, Int> {
        var nx = x + dx[dirIdx]
        var ny = y + dy[dirIdx]

        while (nx in 0..3 && ny in 0..3) {
            if (board[nx][ny] != 0) return Pair(nx, ny)
            nx += dx[dirIdx]
            ny += dy[dirIdx]
        }

        return Pair(nx - dx[dirIdx], ny - dy[dirIdx])
    }
}
