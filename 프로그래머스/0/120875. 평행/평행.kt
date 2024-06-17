class Solution {
    fun solution(dots: Array<IntArray>): Int {
        val (x1, y1) = dots[0]
        val (x2, y2) = dots[1]
        val (x3, y3) = dots[2]
        val (x4, y4) = dots[3]

        return if (isParallel(x1, y1, x2, y2, x3, y3, x4, y4) ||
            isParallel(x1, y1, x3, y3, x2, y2, x4, y4) ||
            isParallel(x1, y1, x4, y4, x2, y2, x3, y3)
        ) 1 else 0
    }

    private fun isParallel(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x4: Int, y4: Int): Boolean {
        return (y1 - y2).toDouble() / (x1 - x2) == (y3 - y4).toDouble() / (x3 - x4)
    }
}