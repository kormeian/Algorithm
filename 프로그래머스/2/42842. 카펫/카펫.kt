class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        val sum = brown + yellow
        for (i in 3 until sum){
            if (sum % i == 0){
                val width = sum / i
                if (width >= i) {
                    if ((width - 2) * (i - 2) == yellow) {
                        answer = intArrayOf(width, i)
                        break
                    }
                }
            }
        }
        return answer
    }
}