class Solution {
    fun solution(n: Int): IntArray {
        val triangle = Array(n) { IntArray(it + 1) }
        var counter = 1
        var x = -1
        var y = 0
        var tempN = n
        while (tempN > 0) {
            for (i in 0 until tempN) triangle[++x][y] = counter++
            for (i in 0 until tempN - 1) triangle[x][++y] = counter++
            for (i in 0 until tempN - 2) triangle[--x][--y] = counter++
            tempN -= 3
        }

        return triangle.flatMap { it.toList() }.toIntArray()
    }
}