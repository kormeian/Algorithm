class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val dp = Array(s.length) { BooleanArray(s.length) }
        for (i in s.indices) {
            dp[i][i] = true
            answer = 1
        }
        for (i in s.indices) {
            if (i + 1 < s.length && s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                answer = 2
            }
        }
        for (i in 2 until s.length) {
            for (j in 0 until s.length - i) {
                if (s[j] == s[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true
                    answer = i + 1
                }
            }
        }
        
        return answer
    }
}