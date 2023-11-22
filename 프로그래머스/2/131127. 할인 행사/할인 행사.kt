class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val arr = number.copyOf()
        val map = mutableMapOf<String, Int>()

        for ((i, item) in want.withIndex()) {
            map[item] = i
        }

        for ((i, item) in discount.withIndex()) {
            if (i >= 10) {
                val minusItem = discount[i - 10]
                val idx = map[minusItem]
                if (idx != null) arr[idx]++
            }

            val idx = map[item] ?: continue
            arr[idx]--

            if (arr.none { it > 0 }) answer++
        }

        return answer
    }
}