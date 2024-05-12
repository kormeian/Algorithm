class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerToIndex = players.indices.associateBy { players[it] }.toMutableMap()
        val indexToPlayer = players.indices.associateWith { players[it] }.toMutableMap()

        for (calling in callings) {
            val index = playerToIndex[calling]!!
            if (index > 0) {
                val prevPlayer = indexToPlayer[index - 1]!!
                playerToIndex[prevPlayer] = index
                playerToIndex[calling] = index - 1
                indexToPlayer[index] = prevPlayer
                indexToPlayer[index - 1] = calling
            }
        }

        return indexToPlayer.values.toTypedArray()
    }
}