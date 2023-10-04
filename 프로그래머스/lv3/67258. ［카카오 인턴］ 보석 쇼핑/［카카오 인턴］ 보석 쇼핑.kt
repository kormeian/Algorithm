class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf()
        var start = 0
        var length = Int.MAX_VALUE
        val gemType = mutableSetOf<String>()
        for (gem in gems) {
            gemType.add(gem)
        }
        val map = mutableMapOf<String, Int>()
        for (end in gems.indices) {
            map[gems[end]] = map.getOrDefault(gems[end], 0) + 1
            if (map.size == gemType.size) {
                while (map[gems[start]]!! > 1) {
                    map[gems[start]] = map[gems[start]]!! - 1
                    start++
                }
                if (length > end - start) {
                    length = end - start
                    answer = intArrayOf(start + 1, end + 1)
                }
            }
        }

        return answer
    }
}