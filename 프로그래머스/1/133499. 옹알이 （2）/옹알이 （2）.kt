class Solution {
    fun solution(babbling: Array<String>): Int {
        val patterns = listOf("aya", "ye", "woo", "ma")
        val validPattern = Regex("^(aya|ye|woo|ma)+$")

        var count = 0

        for (word in babbling) {
            if (validPattern.matches(word)) {
                var isValid = true

                for (pattern in patterns) {
                    if (word.contains("$pattern$pattern")) {
                        isValid = false
                        break
                    }
                }

                if (isValid) {
                    count++
                }
            }
        }

        return count
    }
}
