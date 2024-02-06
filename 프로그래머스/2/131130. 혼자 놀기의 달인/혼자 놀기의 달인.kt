class Solution {
    fun solution(cards: IntArray): Int {
        val visited = BooleanArray(cards.size + 1)
        val groupSizes = mutableListOf<Int>()

        for (i in cards.indices) {
            if (!visited[i + 1]) {
                var count = 0
                var j = i + 1
                while (!visited[j]) {
                    visited[j] = true
                    count++
                    j = cards[j - 1]
                }
                groupSizes.add(count)
            }
        }

        groupSizes.sortDescending()

        return if (groupSizes.size >= 2) groupSizes[0] * groupSizes[1] else 0
    }
}