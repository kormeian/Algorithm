class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var count = 0
        var lastPainted = 0

        for (i in section.indices) {
            if (section[i] > lastPainted) {
                count++
                lastPainted = section[i] + m - 1
            }
        }

        return count
    }
}