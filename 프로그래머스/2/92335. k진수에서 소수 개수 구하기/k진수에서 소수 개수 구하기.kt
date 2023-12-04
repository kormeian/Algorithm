import kotlin.math.sqrt


class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val converted = n.toString(k)
        val numbers = converted.split("0")

        for (number in numbers) {
            if (number.isNotEmpty() && isPrime(number.toLong())) {
                answer++
            }
        }

        return answer
    }

    private fun isPrime(num: Long): Boolean {
        if (num < 2) return false
        for (i in 2..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0.toLong()) return false
        }
        return true
    }
}