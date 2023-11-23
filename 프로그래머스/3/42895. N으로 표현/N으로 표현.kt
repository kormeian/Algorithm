class Solution {
    fun solution(N: Int, number: Int): Int {
        if (N == number) return 1
        val dp = Array(9) { mutableSetOf<Int>() }
        dp[1].add(N)
        for (i in 2..8) {
            for (j in 1 until i) {
                union(dp[i], dp[j], dp[i - j])
            }
            dp[i].add(N.toString().repeat(i).toInt())
            if (dp[i].contains(number)) return i
        }
        return -1
    }

    private fun union(set: MutableSet<Int>, a: Set<Int>, b: Set<Int>) {
        for (i in a) {
            for (j in b) {
                set.add(i + j)
                set.add(i - j)
                set.add(i * j)
                if (j != 0) set.add(i / j)
            }
        }
    }
}