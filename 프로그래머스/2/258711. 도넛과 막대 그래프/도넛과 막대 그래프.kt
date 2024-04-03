class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, IntArray>()
        for ((a, b) in edges) {
            map.putIfAbsent(a, intArrayOf(0, 0))
            map.putIfAbsent(b, intArrayOf(0, 0))

            map[a]!![0] += 1
            map[b]!![1] += 1
        }
        val answer = intArrayOf(0, 0, 0, 0)
        for ((key, counts) in map) {
            if (counts[0] >= 2 && counts[1] == 0) {
                answer[0] = key
            } else if (counts[0] == 0 && counts[1] > 0) {
                answer[2] += 1
            } else if (counts[0] >= 2 && counts[1] >= 2) {
                answer[3] += 1
            }
        }
        answer[1] = (map[answer[0]]!![0] - answer[2] - answer[3])
        return answer
    }
}