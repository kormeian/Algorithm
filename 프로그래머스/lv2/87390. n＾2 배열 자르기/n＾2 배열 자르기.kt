class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val len = right.toInt() - left.toInt()
        val answer = IntArray(len + 1)

        for ((idx, i) in (left..right).withIndex()) {
            val row = i / n
            val col = i % n
            answer[idx] = row.toInt().coerceAtLeast(col.toInt()) + 1
        }
        return answer
    }
}