class Solution {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var num = storey
        while (num > 0) {
            val remain = num % 10
            num /= 10
            if (remain == 5) {
                if (num % 10 >= 5) {
                    answer += 10 - remain
                    num++
                } else {
                    answer += remain
                }
            } else if (remain > 5) {
                answer += 10 - remain
                num++
            } else {
                answer += remain
            }
        }
        return answer
    }
}