class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        weights.sort()
        val map = mutableMapOf<Double, Int>()
        for (i in weights) {
            val a = i.toDouble()
            val b = i * 2.0 / 3.0
            val c = i / 2.0
            val d = i * 3.0 / 4.0
            answer += map.getOrDefault(a, 0)
            answer += map.getOrDefault(b, 0)
            answer += map.getOrDefault(c, 0)
            answer += map.getOrDefault(d, 0)
            map[a] = map.getOrDefault(a, 0) + 1
        }

        return answer
    }
}