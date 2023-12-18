class Solution {
    fun solution(a: Int, b: Int, g: IntArray, s: IntArray, w: IntArray, t: IntArray): Long {
        var answer = (10e9 * 2 * 10e5 * 2).toLong()
        var start = 0L
        var end = answer

        while (start <= end) {
            val mid = (start + end) / 2
            var gold = 0L
            var silver = 0L
            var total = 0L

            for (i in 0 until g.size) {
                val curG = g[i].toLong()
                val curS = s[i].toLong()
                val curW = w[i].toLong()
                val time = t[i].toLong()

                var moveCount = mid / (time * 2)
                if (mid % (time * 2) >= t[i]) {
                    moveCount++
                }

                gold += minOf(curG, moveCount * curW)
                silver += minOf(curS, moveCount * curW)
                total += minOf(curG + curS, moveCount * curW)
            }

            if (a <= gold && b <= silver && a + b <= total) {
                end = mid - 1
                answer = minOf(mid, answer)
                continue
            }

            start = mid + 1
        }

        return answer
    }
}