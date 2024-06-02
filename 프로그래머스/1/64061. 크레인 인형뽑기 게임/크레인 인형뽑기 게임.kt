class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = ArrayDeque<Int>()
        val stackList = mutableListOf<ArrayDeque<Int>>()
        for (i in board[0].indices) {
            val temp = ArrayDeque<Int>()
            for (j in board.indices) {
                if (board[j][i] != 0) {
                    temp.add(board[j][i])
                }
            }
            stackList.add(temp)
        }
        for (move in moves) {
            val temp = stackList[move - 1]
            if (temp.isNotEmpty()) {
                val doll = temp.removeFirst()
                if (stack.isNotEmpty() && stack.last() == doll) {
                    stack.removeLast()
                    answer += 2
                } else {
                    stack.add(doll)
                }
            }
        }
        return answer
    }
}