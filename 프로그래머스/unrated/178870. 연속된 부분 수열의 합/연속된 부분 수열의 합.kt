class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var left = 0
        var right = 0
        var sum = 0
        var length = Int.MAX_VALUE

        while (right < sequence.size && left <= right) {
            if (left == right) {
                sum = sequence[left]
            }
            if (sum == k) {
                if (length > right - left + 1) {
                    length = right - left + 1
                    answer = intArrayOf(left, right)
                }
                sum -= sequence[left]
                if (right + 1 < sequence.size) {
                    sum += sequence[right + 1]
                }
                if (left == right) {
                    break
                }
                left++
                right++
            } else if (sum > k) {
                sum -= sequence[left]
                left++
            } else {
                if (right + 1 < sequence.size) {
                    sum += sequence[right + 1]
                }
                right++
            }
        }
        return answer
    }
}