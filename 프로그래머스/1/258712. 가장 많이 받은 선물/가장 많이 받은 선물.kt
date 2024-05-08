class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val gGiftsMap = mutableMapOf<String, MutableMap<String, Int>>()
        val tGiftsGivenMap = mutableMapOf<String, Int>()
        val tGiftsReceivedMap = mutableMapOf<String, Int>()
        val nGiftsMap = mutableMapOf<String, Int>()

        for (gift in gifts) {
            val (giver, receiver) = gift.split(" ")
            gGiftsMap.getOrPut(giver) { mutableMapOf() }[receiver] = gGiftsMap[giver]?.getOrDefault(receiver, 0)?.plus(1) ?: 0
            tGiftsGivenMap[giver] = tGiftsGivenMap.getOrDefault(giver, 0) + 1
            tGiftsReceivedMap[receiver] = tGiftsReceivedMap.getOrDefault(receiver, 0) + 1
        }

        for (i in friends.indices) {
            for (j in i + 1 until friends.size) {
                val f1 = friends[i]
                val f2 = friends[j]

                val giftsF1ToF2 = gGiftsMap[f1]?.getOrDefault(f2, 0) ?: 0
                val giftsF2ToF1 = gGiftsMap[f2]?.getOrDefault(f1, 0) ?: 0

                if (giftsF1ToF2 > giftsF2ToF1) {
                    nGiftsMap[f1] = nGiftsMap.getOrDefault(f1, 0) + 1
                } else if (giftsF2ToF1 > giftsF1ToF2) {
                    nGiftsMap[f2] = nGiftsMap.getOrDefault(f2, 0) + 1
                } else {
                    val gIndexF1 = tGiftsGivenMap.getOrDefault(f1, 0) - tGiftsReceivedMap.getOrDefault(f1, 0)
                    val gIndexF2 = tGiftsGivenMap.getOrDefault(f2, 0) - tGiftsReceivedMap.getOrDefault(f2, 0)

                    if (gIndexF1 > gIndexF2) {
                        nGiftsMap[f1] = nGiftsMap.getOrDefault(f1, 0) + 1
                    } else if (gIndexF2 > gIndexF1) {
                        nGiftsMap[f2] = nGiftsMap.getOrDefault(f2, 0) + 1
                    }
                }
            }
        }

        return nGiftsMap.values.maxOrNull() ?: 0
    }
}