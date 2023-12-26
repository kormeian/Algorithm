class Solution {
    fun solution(number: String, k: Int): String {
        val stack = mutableListOf<Char>()
        var k = k

        for (num in number) {
            while (stack.isNotEmpty() && stack.last() < num && k > 0) {
                stack.removeAt(stack.size - 1)
                k--
            }
            stack.add(num)
        }

        for (i in 0 until k) {
            stack.removeAt(stack.size - 1)
        }

        return stack.joinToString("")
    }
}