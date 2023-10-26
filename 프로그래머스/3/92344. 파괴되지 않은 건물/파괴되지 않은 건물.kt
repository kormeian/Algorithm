class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer = 0
        val temp = Array(board.size + 1) { IntArray(board[0].size + 1) { 0 } }
        skill.forEach {
            val type = it[0]
            val r1 = it[1]
            val c1 = it[2]
            val r2 = it[3]
            val c2 = it[4]
            val degree = it[5]
            temp[r1][c1] += if (type == 1) -degree else degree
            temp[r1][c2 + 1] += if (type == 1) degree else -degree
            temp[r2 + 1][c1] += if (type == 1) degree else -degree
            temp[r2 + 1][c2 + 1] += if (type == 1) -degree else degree
        }
        for (i in temp.indices) {
            for (j in 1 until temp[0].size) {
                temp[i][j] += temp[i][j - 1]
            }
        }
        for (i in 1 until temp.size) {
            for (j in temp[0].indices) {
                temp[i][j] += temp[i - 1][j]
            }
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] + temp[i][j] > 0) {
                    answer++
                }
            }
        }
        return answer
    }
}