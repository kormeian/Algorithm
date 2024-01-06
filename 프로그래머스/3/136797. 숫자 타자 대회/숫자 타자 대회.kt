import kotlin.math.min

class Solution {
    private val cost = arrayOf(
        intArrayOf(1, 7, 6, 7, 5, 4, 5, 3, 2, 3),
        intArrayOf(7, 1, 2, 4, 2, 3, 5, 4, 5, 6),
        intArrayOf(6, 2, 1, 2, 3, 2, 3, 5, 4, 5),
        intArrayOf(7, 4, 2, 1, 5, 3, 2, 6, 5, 4),
        intArrayOf(5, 2, 3, 5, 1, 2, 4, 2, 3, 5),
        intArrayOf(4, 3, 2, 3, 2, 1, 2, 3, 2, 3),
        intArrayOf(5, 5, 3, 2, 4, 2, 1, 5, 3, 2),
        intArrayOf(3, 4, 5, 6, 2, 3, 5, 1, 2, 4),
        intArrayOf(2, 5, 4, 5, 3, 2, 3, 2, 1, 2),
        intArrayOf(3, 6, 5, 4, 5, 3, 2, 4, 2, 1)
    )

    private lateinit var dp: Array<Array<Array<Int>>>

    fun solution(numbers: String): Int {
        dp = Array(numbers.length + 1) { Array(10) { Array(10) { -1 } } }
        return dfs(0, 4, 6, numbers)
    }

    private fun dfs(index: Int, left: Int, right: Int, numbers: String): Int {
        if (index == numbers.length) {
            return 0
        }
        if (dp[index][left][right] != -1) return dp[index][left][right]

        val num = numbers[index] - '0'
        var result = Int.MAX_VALUE

        if (num != right) result = min(dfs(index + 1, num, right, numbers) + cost[left][num], result)
        if (num != left) result = min(dfs(index + 1, left, num, numbers) + cost[right][num], result)

        return result.also { dp[index][left][right] = it }
    }
}