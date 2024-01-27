class Solution {
    private val moves = mutableListOf<IntArray>()

    fun solution(n: Int): Array<IntArray> {
        hanoi(n, 1, 2, 3)
        return moves.toTypedArray()
    }

    private fun hanoi(n: Int, from: Int, aux: Int, to: Int) {
        if (n == 1) {
            moves.add(intArrayOf(from, to))
        } else {
            hanoi(n - 1, from, to, aux)
            moves.add(intArrayOf(from, to))
            hanoi(n - 1, aux, from, to)
        }
    }
}