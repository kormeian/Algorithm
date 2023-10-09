class Solution {
    fun solution(s: String): String {
        var answer = ""
        val list = s.split(" ")
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (i in list) {
            val num = i.toInt()
            if (num < min) {
                min = num
            }
            if (num > max) {
                max = num
            }
        }
        answer = "$min $max"
        return answer
    }
}