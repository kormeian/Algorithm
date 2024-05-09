class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer = 0
        val words = setOf("aya", "ye", "woo", "ma")

        for (b in babbling) {
            var cnt = 0
            var word = ""
            for (char in b) {
                word += char
                if (word in words) {
                    word = ""
                    cnt++
                }
            }
            if (word.isEmpty() && cnt > 0) {
                answer++
            }
        }

        return answer
    }
}