class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val slice = if (minerals.size > picks.sum() * 5) minerals.slice(0 until picks.sum() * 5).toList()
            .chunked(5) else minerals.toList().chunked(5)
        val arr = Array(slice.size) { IntArray(3) }
        slice.forEachIndexed { index, mineral ->
            var diamond = 0
            var iron = 0
            var stone = 0
            mineral.forEach { v ->
                when (v) {
                    "diamond" -> diamond++
                    "iron" -> iron++
                    else -> stone++
                }
            }
            arr[index][0] = diamond
            arr[index][1] = iron
            arr[index][2] = stone
        }
        val s = arr.toList().sortedWith(compareBy({ -it[0] }, { -it[1] }, { -it[2] }))
        s.forEach {
            if (picks[0] != 0) {
                answer += it[0] + it[1] + it[2]
                picks[0] -= 1
            } else if (picks[1] != 0) {
                answer += it[0] * 5 + it[1] + it[2]
                picks[1] -= 1
            } else {
                answer += it[0] * 25 + it[1] * 5 + it[2]
                picks[2] -= 1
            }
        }
        return answer
    }
}