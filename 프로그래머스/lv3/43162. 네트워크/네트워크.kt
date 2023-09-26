import java.util.*
class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val connected = BooleanArray(n) { false }
        val stack: Stack<Int> = Stack()
        for (i in 0 until n) {
            if (!connected[i]) {
                stack.push(i)
                connected[i] = true
                answer++
                while (!stack.isEmpty()) {
                    val current = stack.pop()
                    for (j in 0 until n) {
                        if (!connected[j] && computers[current][j] == 1) {
                            stack.push(j)
                            connected[j] = true
                        }
                    }
                }
            }
        }
        return answer
    }
}