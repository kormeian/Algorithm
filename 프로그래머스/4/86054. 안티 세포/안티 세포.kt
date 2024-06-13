class Solution {
    private val mod = 1_000_000_007

    fun solution(a: IntArray, s: IntArray): IntArray {
        val answer = IntArray(s.size)
        var start: Int
        var end = 0
        for (t in s.indices) {
            val n = s[t]
            start = end
            end = start + n
            val sum = LongArray(n + 1)
            sum[0] = 1
            val levels = MutableList<MutableMap<Long, Int>>(n + 1) { mutableMapOf() }
            levels[0][-1L] = -1
            for (i in 1..n) {
                sum[i] = connect(a[start + i - 1].toLong(), i, i - 1, sum, levels)
            }
            answer[t] = (sum[n] % mod).toInt()
        }
        return answer
    }

    private fun connect(num: Long, here: Int, par: Int, sum: LongArray, levels: List<MutableMap<Long, Int>>): Long {
        val level = levels[here]
        level.getOrPut(num) { par }
        var ret = sum[par]
        levels[par][num]?.let {
            ret += connect(num * 2, here, it, sum, levels)
            ret %= mod
        }
        return ret
    }
}