import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer = 0L
        for (i in 0..d step k) {
            val y = sqrt(d.toDouble().pow(2) - i.toDouble().pow(2))
            answer += floor(y / k).toLong() + 1
        }
        return answer
    }
}