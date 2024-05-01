import kotlin.math.min
import kotlin.math.pow

class Solution {
    private val dx = arrayOf(0, -1, 1, 0, 0)
    private val dy = arrayOf(0, 0, 0, 1, -1)

    fun solution(clockHands: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        val length = clockHands.size

        for (i in 0 until 4.0.pow(length.toDouble()).toInt()) {
            var tmp = 0
            val tmpClock = clockHands.map { it.clone() }.toTypedArray()
            for (j in 0 until length) {
                val rt = i % 4.0.pow((j + 1).toDouble()).toInt() / 4.0.pow(j.toDouble()).toInt()
                if (rt == 0) {
                    continue
                }
                rotate(j, 0, tmpClock, rt)
                tmp += rt
            }

            for (y in 1 until length) {
                for (x in 0 until length) {
                    if (tmpClock[y - 1][x] == 0) {
                        continue
                    }
                    val rt = 4 - tmpClock[y - 1][x]
                    rotate(x, y, tmpClock, rt)
                    tmp += rt
                }
            }
            if (tmpClock.last().sum() == 0) {
                answer = min(answer, tmp)
            }
        }

        return answer
    }

    private fun rotate(x: Int, y: Int, lst: Array<IntArray>, rt: Int) {
        val length = lst.size
        for (k in 0 until 5) {
            val ax = x + dx[k]
            val ay = y + dy[k]
            if (ax in 0 until length && ay in 0 until length) {
                lst[ay][ax] = (lst[ay][ax] + rt) % 4
            }
        }
    }
}