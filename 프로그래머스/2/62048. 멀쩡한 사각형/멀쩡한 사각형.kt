class Solution {
    fun solution(w: Int, h: Int): Long {
        var width = w * 1L
        var height = h * 1L
        return width * height - (width + height - gcd(width, height))
    }

    private fun gcd(a: Long, b: Long): Long {
        var a = a
        var b = b
        while (b > 0) {
            val temp = b
            b = a % b
            a = temp
        }
        return a
    }
}