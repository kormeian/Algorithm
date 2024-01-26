class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        data.sortWith(compareBy({ it[col - 1] }, { -it[0] }))

        var hashValue = 0
        for (i in row_begin - 1 until row_end) {
            var sum = 0
            for (j in data[i].indices) {
                sum += data[i][j] % (i + 1)
            }
            hashValue = hashValue xor sum
        }

        return hashValue
    }
}