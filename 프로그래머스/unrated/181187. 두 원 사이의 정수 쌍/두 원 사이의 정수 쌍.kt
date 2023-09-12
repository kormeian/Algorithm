import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0

        for (i in 1..r2) {
            val min = ceil(sqrt(1.0 * r1 * r1 - 1.0 * i * i)).toInt().toLong()
            val max = floor(sqrt(1.0 * r2 * r2 - 1.0 * i * i)).toInt().toLong()
            answer += max - min + 1
        }

        return answer * 4
    }
}