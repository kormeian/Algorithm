class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer = 0
        val deque = ArrayDeque<Int>()
        ingredient.forEach {
            deque.add(it)
            if (deque.size >= 4 && deque.isBurger()) {
                deque.removeLast()
                deque.removeLast()
                deque.removeLast()
                deque.removeLast()
                answer++
            }
        }
        return answer
    }

    private fun ArrayDeque<Int>.isBurger(): Boolean {
        return this[this.size - 1] == 1 &&
                this[this.size - 2] == 3 &&
                this[this.size - 3] == 2 &&
                this[this.size - 4] == 1
    }
}