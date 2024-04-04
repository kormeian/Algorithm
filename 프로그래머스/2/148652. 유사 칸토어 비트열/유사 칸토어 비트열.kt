class Solution {
    fun solution(n: Int, l: Long, r: Long): Int {
        var answer: Int = 0
        for (i in l - 1 until r) {
            if (isOne(i)) answer++
        }
        return answer
    }

    private fun isOne(l: Long): Boolean {
        var temp = l
        while (temp >= 5) {
            if ((temp - 2) % 5 == 0.toLong()) return false
            temp /= 5
        }
        return temp != 2.toLong()
    }
}