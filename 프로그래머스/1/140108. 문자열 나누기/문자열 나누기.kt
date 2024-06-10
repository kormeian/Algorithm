class Solution {
    fun solution(s: String): Int {
        var partitions = 0
        var firstCharCount = 0
        var otherCharCount = 0
        var firstChar = s[0]

        for (i in s.indices) {
            if (s[i] == firstChar) {
                firstCharCount++
            } else {
                otherCharCount++
            }
            if (firstCharCount == otherCharCount) {
                partitions++
                firstCharCount = 0
                otherCharCount = 0
                if (i < s.length - 1) {
                    firstChar = s[i + 1]
                }
            }
        }

        if (firstCharCount != otherCharCount) {
            partitions++
        }

        return partitions
    }
}