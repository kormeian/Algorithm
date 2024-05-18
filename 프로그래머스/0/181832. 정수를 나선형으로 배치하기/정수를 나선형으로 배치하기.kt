class Solution {
    fun solution(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        var num = 1
        var row = 0
        var col = -1
        var temp = n
        var direction = 1

        while (true) {
            for (i in 0 until temp) {
                col += direction
                result[row][col] = num++
            }

            temp -= 1
            if (temp < 0) break

            for (i in 0 until temp) {
                row += direction
                result[row][col] = num++
            }

            direction *= -1
        }

        return result
    }
}