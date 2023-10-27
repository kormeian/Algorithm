import java.util.*

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var current = k
        val stack = Stack<Int>()
        var size = n

        for (element in cmd) {
            val c = element.split(" ")

            when (c[0]) {
                "D" -> current += c[1].toInt() 
                "U" -> current -= c[1].toInt() 
                "C" -> {
                    size--
                    stack.add(current)
                    current = if (current == size) {current - 1} else current
                }
                "Z" -> {
                    size++
                    current = if(stack.pop() <= current) current + 1 else current
                }
            }
        }
        val sb = StringBuilder()
        sb.append("O".repeat(size))
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), 'X')
        }

        return sb.toString()
    }
}