class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = -1
        val cnt = IntArray(a.size)
        a.forEach { cnt[it]++ }
        cnt.forEachIndexed { i, v ->
            if (v <= answer) return@forEachIndexed
            var count = 0
            var j = 0
            while (j < a.size - 1) {
                if (a[j] != a[j + 1] && (a[j] == i || a[j + 1] == i)) {
                    count++
                    j++
                }
                j++
            }
            answer = answer.coerceAtLeast(count)
        }
        return answer * 2
    }
}