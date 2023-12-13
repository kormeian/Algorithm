class Solution {
    fun solution(word: String): Int {
        val vowels = listOf('A', 'E', 'I', 'O', 'U')
        var answer = 0
        var mul = 781
        for (i in word.indices) {
            for (j in vowels.indices) {
                if (word[i] == vowels[j]) {
                    answer += 1 + j * mul
                }
            }
            mul = (mul - 1) / 5
        }
        return answer
    }
}