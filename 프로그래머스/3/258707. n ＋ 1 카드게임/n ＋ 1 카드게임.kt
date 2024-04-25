class Solution {
    fun solution(coin: Int, cards: IntArray): Int {
        val currentHands = cards.take(cards.size / 3).toMutableList()
        val remainingCards = ArrayDeque<Int>(cards.drop(cards.size / 3))
        val pending = mutableListOf<Int>()
        var answer = 1
        var coins = coin
        while (coins >= 0 && remainingCards.isNotEmpty()) {
            pending.add(remainingCards.removeFirst())
            pending.add(remainingCards.removeFirst())

            when {
                check(currentHands, currentHands, cards.size + 1) -> {}
                coins >= 1 && check(currentHands, pending, cards.size + 1) -> coins -= 1
                coins >= 2 && check(pending, pending, cards.size + 1) -> coins -= 2
                else -> break
            }
            answer += 1
        }
        return answer
    }

    private fun check(deck1: MutableList<Int>, deck2: MutableList<Int>, target: Int): Boolean {
        for (card in deck1) {
            if (target - card in deck2) {
                deck1.remove(card)
                deck2.remove(target - card)
                return true
            }
        }
        return false
    }
}