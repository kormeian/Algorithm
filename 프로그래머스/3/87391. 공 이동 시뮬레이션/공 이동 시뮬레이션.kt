class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, queries: Array<IntArray>): Long {
        var (xMin, xMax, yMin, yMax) = longArrayOf(x.toLong(), x.toLong(), y.toLong(), y.toLong())
        queries.reverse()
        queries.forEach { query ->
            val (dir, dist) = query
            if (dir == 0) {
                yMax += dist
                if (yMax >= m) yMax = (m - 1).toLong()
                if (yMin != 0.toLong()) yMin += dist
            } else if (dir == 1) {
                yMin -= dist
                if (yMin < 0) yMin = 0
                if (yMax != (m - 1).toLong()) yMax -= dist
            } else if (dir == 2) {
                xMax += dist
                if (xMax >= n) xMax = (n - 1).toLong()
                if (xMin != 0.toLong()) xMin += dist
            } else if (dir == 3) {
                xMin -= dist
                if (xMin < 0) xMin = 0
                if (xMax != (n - 1).toLong()) xMax -= dist
            }
            if (yMin >= m || yMax < 0 || xMin >= n || xMax < 0) return 0
        }
        return (yMax - yMin + 1) * (xMax - xMin + 1)
    }
}