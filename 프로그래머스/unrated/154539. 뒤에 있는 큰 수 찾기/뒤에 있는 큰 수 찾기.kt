import java.util.*
class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = Array(numbers.size) { 0 }.toIntArray()
        val stack = Stack<Int>()
        stack.push(0)
        for (i in 1 until numbers.size) {
            while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }
        while (stack.isNotEmpty()) {
            answer[stack.pop()] = -1
        }
        return answer
    }
}