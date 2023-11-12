class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var tempA = a
        var tempB = b
        while (tempA != tempB) {
            tempA = tempA / 2 + tempA % 2
            tempB = tempB / 2 + tempB % 2
            answer++
        }
        return answer
    }
}