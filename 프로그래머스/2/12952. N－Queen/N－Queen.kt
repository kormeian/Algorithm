import kotlin.math.abs

class Solution {
    private lateinit var cols: IntArray
    private var answer = 0
    fun solution(n: Int): Int {
        cols = IntArray(n)
        backtracking(0, n)
        return answer
    }

    private fun isValid(index: Int): Boolean {
        for (i in 0 until index) {
            if (cols[index] == cols[i] || abs(cols[index] - cols[i]) == abs(index - i)) {
                return false
            }
        }
        return true
    }

    private fun backtracking(depth: Int, n: Int) {
        if (depth == n) {
            answer++
            return
        }
        for (i in 0 until n) {
            cols[depth] = i
            if (isValid(depth)) {
                backtracking(depth + 1, n)
            }
        }
    }
}