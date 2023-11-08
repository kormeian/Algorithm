class Solution {
    fun solution(s: Array<String>): Array<String> {
        val answer = Array(s.size) { "" }
        s.forEachIndexed { index, it ->
            answer[index] = sort(it)
        }
        return answer
    }

    private fun sort(s: String): String {
        val stack = ArrayDeque<Char>()
        var cnt = 0
        s.forEach {
            if (stack.size < 2) {
                stack.add(it)
            } else {
                if (stack[stack.size - 2] == '1' && stack[stack.size - 1] == '1' && it == '0') {
                    stack.removeLast()
                    stack.removeLast()
                    cnt++
                } else {
                    stack.add(it)
                }
            }
        }
        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.removeFirst())
        }
        val idx = sb.indexOfLast { it == '0' }
        return if (idx == -1) {
            "110".repeat(cnt) + sb.toString()
        } else {
            sb.substring(0, idx + 1) + "110".repeat(cnt) + sb.substring(idx + 1)
        }
    }
}