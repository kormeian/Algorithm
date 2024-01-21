class Solution {
    private lateinit var array: Array<IntArray>
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)
        array = Array(rows) { IntArray(columns) }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                array[i][j] = i * columns + j + 1
            }
        }
        for (i in queries.indices) {
            answer[i] = rotateArray(queries[i])
        }
        return answer
    }

    private fun rotateArray(query: IntArray): Int {
        var answer = 0
        val x1 = query[0] - 1
        val y1 = query[1] - 1
        val x2 = query[2] - 1
        val y2 = query[3] - 1
        val temp = array[x1][y1]
        var min = temp
        for (i in x1 until x2) {
            array[i][y1] = array[i + 1][y1]
            if (min > array[i][y1]) {
                min = array[i][y1]
            }
        }
        for (i in y1 until y2) {
            array[x2][i] = array[x2][i + 1]
            if (min > array[x2][i]) {
                min = array[x2][i]
            }
        }
        for (i in x2 downTo x1 + 1) {
            array[i][y2] = array[i - 1][y2]
            if (min > array[i][y2]) {
                min = array[i][y2]
            }
        }
        for (i in y2 downTo y1 + 1) {
            array[x1][i] = array[x1][i - 1]
            if (min > array[x1][i]) {
                min = array[x1][i]
            }
        }
        array[x1][y1 + 1] = temp
        answer = min
        return answer
    }
}