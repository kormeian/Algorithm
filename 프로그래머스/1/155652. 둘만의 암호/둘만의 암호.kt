class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val skipSet = skip.toSet()

        fun nextChar(c: Char, index: Int): Char {
            var next = c
            repeat(index) {
                next = if (next == 'z') 'a' else next + 1
                while (next in skipSet) {
                    next = if (next == 'z') 'a' else next + 1
                }
            }
            return next
        }

        return s.map { nextChar(it, index) }.joinToString("")
    }
}