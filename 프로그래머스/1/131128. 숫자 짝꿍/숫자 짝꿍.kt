class Solution {
    fun solution(X: String, Y: String): String {
        var answer = ""

        for (i in 9 downTo 0) {
            val countX = X.count { it.toString() == "$i" }
            val countY = Y.count { it.toString() == "$i" }
            answer += "$i".repeat(minOf(countX, countY))
        }

        return when {
            answer.isEmpty() -> "-1"
            answer.all { it == '0' } -> "0"
            else -> answer
        }
    }
}