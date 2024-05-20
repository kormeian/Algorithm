class Solution {
    fun solution(rc: Array<IntArray>, operations: Array<String>): Array<IntArray> {
        val n = rc.size
        val m = rc[0].size

        val rows = ArrayDeque<ArrayDeque<Int>>()
        rc.forEach { row -> rows.addLast(ArrayDeque(row.slice(1 until m - 1))) }

        val outCols = arrayOf(
            ArrayDeque(rc.map { it[0] }),
            ArrayDeque(rc.map { it[m - 1] })
        )

        operations.forEach { operation ->
            when (operation) {
                "ShiftRow" -> {
                    rows.addFirst(rows.removeLast())
                    outCols[0].addFirst(outCols[0].removeLast())
                    outCols[1].addFirst(outCols[1].removeLast())
                }

                "Rotate" -> {
                    rows.last().addLast(outCols[1].removeLast())
                    outCols[0].addLast(rows.last().removeFirst())
                    rows.first().addFirst(outCols[0].removeFirst())
                    outCols[1].addFirst(rows.first().removeLast())
                }
            }
        }

        val answer = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            answer[r][0] = outCols[0][r]
            answer[r][m - 1] = outCols[1][r]
            for (c in 1 until m - 1) {
                answer[r][c] = rows[r][c - 1]
            }
        }

        return answer
    }
}