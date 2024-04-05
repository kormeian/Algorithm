import kotlin.math.min

class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val answer: IntArray = IntArray(balls.size)
        balls.forEachIndexed { index, (x, y) ->
            if (startX == x) {
                val d1 = intPow(y - startY) + 4 * intPow(startX)
                val d2 = intPow(y - startY) + 4 * intPow(m - startX)
                val d3 = if (startY < y) intPow(y + startY) else intPow(2 * n - startY - y)
                answer[index] = min(min(d1, d2), d3)
            } else if (startY == y) {
                val d1 = intPow(x - startX) + 4 * intPow(startY)
                val d2 = intPow(x - startX) + 4 * intPow(n - startY)
                val d3 = if (startX < x) intPow(x + startX) else intPow(2 * m - startX - x)
                answer[index] = min(min(d1, d2), d3)
            } else {
                val d1 = intPow(x - startX) + intPow(y + startY)
                val d2 = intPow(x + startX) + intPow(y - startY)
                val d3 = intPow(y - startY) + intPow(2 * m - startX - x)
                val d4 = intPow(x - startX) + intPow(2 * n - startY - y)
                answer[index] = min(min(d1, d2), min(d3, d4))
            }
        }
        return answer
    }

    private fun intPow(a: Int): Int {
        return a * a
    }
}