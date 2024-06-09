class Solution {
    fun solution(s: String): Long {
        val characterGroupCount = mutableMapOf<Char, MutableMap<Int, Int>>()
        var i = 0
        while (i < s.length) {
            val currentChar = s[i]
            var j = i
            while (j < s.length && s[j] == currentChar) {
                j++
            }
            val groupLength = j - i
            characterGroupCount.getOrPut(currentChar) { mutableMapOf() }[groupLength] =
                characterGroupCount[currentChar]?.getOrDefault(groupLength, 0)?.plus(1) ?: 1
            i = j
        }

        var answer = (s.length.toLong() - 1) * s.length * (s.length + 1) / 6
        for (groupCount in characterGroupCount.values) {
            var totalCount = groupCount.values.sum()
            var totalLength = groupCount.entries.sumOf { it.key * it.value }
            for (length in 1..groupCount.keys.maxOrNull()!!) {
                answer -= totalLength.toLong() * (totalLength - 1) / 2
                totalLength -= totalCount
                totalCount -= groupCount.getOrDefault(length, 0)
            }
        }
        return answer
    }
}