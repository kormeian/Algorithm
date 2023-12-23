import kotlin.math.sqrt
class Solution {
    private val primeNumbers = HashSet<Int>()

    fun solution(numbers: String): Int {
        permutation("", numbers)
        return primeNumbers.size
    }

    private fun permutation(prefix: String, str: String) {
        val n = str.length
        if (prefix != "") {
            val num = prefix.toInt()
            if (isPrimeNumber(num)) {
                primeNumbers.add(num)
            }
        }
        if (n != 0) {
            for (i in 0 until n) {
                permutation(prefix + str[i], str.substring(0, i) + str.substring(i + 1, n))
            }
        }
    }

    private fun isPrimeNumber(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) return false
        }
        return true
    }
}