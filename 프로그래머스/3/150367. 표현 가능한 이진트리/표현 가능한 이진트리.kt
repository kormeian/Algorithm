import kotlin.math.pow

class Solution {
    fun solution(numbers: LongArray): IntArray {
        val answer = IntArray(numbers.size)
        numbers.forEachIndexed { index, number ->
            var binaryString = number.toString(2)
            var idx = 1
            var len = 0
            while (len <= binaryString.length) {
                len = 2.0.pow(idx.toDouble()).toInt()
                idx++
            }
            binaryString = binaryString.padStart(len - 1, '0')
            answer[index] = if (isToBinaryTree(binaryString)) 1 else 0
        }
        return answer
    }

    private fun isToBinaryTree(
        binaryString: String
    ): Boolean {
        if (binaryString.length == 1) return true

        val firstChar = binaryString.first()
        if (binaryString.all { it == firstChar }) return true

        val mid = binaryString.length / 2
        if (binaryString[mid] == '0') return false

        val left = binaryString.substring(0, binaryString.length / 2)
        val right = binaryString.substring(binaryString.length / 2 + 1)
        return isToBinaryTree(left) && isToBinaryTree(right)
    }
}