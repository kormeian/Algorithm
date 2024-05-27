class Solution {
    
    private var n = 0
    private var m = 0

    fun solution(beginning: Array<IntArray>, target: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        n = beginning.size
        m = beginning[0].size
        val board = Array(n) { i -> IntArray(m) { j -> if (beginning[i][j] != target[i][j]) 1 else 0 } }

        for (bits in 0 until (1 shl n)) {
            val (flipped, rowCnt) = flip(board.copyOf(), bits)
            val colCnt = check(flipped)
            if (colCnt == -1) {
                continue
            }
            answer = minOf(rowCnt + colCnt, answer)
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    private fun flip(array: Array<IntArray>, bits: Int): Pair<Array<IntArray>, Int> {
        var cnt = 0
        for (i in 0 until n) {
            if (bits and (1 shl i) != 0) {
                array[i] = array[i].map { 1 - it }.toIntArray()
                cnt++
            }
        }
        return Pair(array, cnt)
    }

    private fun check(array: Array<IntArray>): Int {
        var cnt = 0
        for (j in 0 until m) {
            val set = mutableSetOf<Int>()
            for (row in array) {
                set.add(row[j])
            }
            if (set.size == 2) {
                return -1
            } else if (set.contains(1)) {
                cnt++
            }
        }
        return cnt
    }
}