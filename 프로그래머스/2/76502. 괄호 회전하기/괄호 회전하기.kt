class Solution {
    fun solution(s: String): Int {
        return s.indices.count { isRight(s.substring(it) + s.substring(0, it)) }
    }

    private fun isRight(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        if (s[0] == ']' || s[0] == '}' || s[0] == ')') return false
        s.forEach {
            when (it) {
                '[' -> stack.addLast('[')
                '{' -> stack.addLast('{')
                '(' -> stack.addLast('(')
                ']' -> if (stack.isNotEmpty() && stack.last() == '[') stack.removeLast() else return false
                '}' -> if (stack.isNotEmpty() && stack.last() == '{') stack.removeLast() else return false
                ')' -> if (stack.isNotEmpty() && stack.last() == '(') stack.removeLast() else return false
            }
        }
        return stack.isEmpty()
    }
}