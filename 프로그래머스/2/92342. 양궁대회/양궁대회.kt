class Solution {
    private var maxScore = 0
    private var maxList = mutableListOf<Int>()

    private fun ryanScore(index: Int, score: MutableList<Int>, n: Int, apeach: IntArray) {
        if (n == 0) {
            calScore(score.toIntArray(), apeach)
            return
        }
        if (index == 11) return

        val sc = apeach[index]
        for (i in 0..sc + 1) {
            score[index] = i
            ryanScore(index + 1, score, n - i, apeach)
            score[index] = 0
        }
    }

    private fun calScore(ryan: IntArray, apeach: IntArray) {
        var rScore = 0
        var aScore = 0

        for (i in 0 until 11) {
            if (ryan[i] == 0 && apeach[i] == 0) continue
            if (ryan[i] > apeach[i]) rScore += (10 - i)
            else aScore += (10 - i)
        }

        if (rScore > aScore) {
            val diff = rScore - aScore
            if (diff > maxScore) {
                maxScore = diff
                maxList = ryan.toMutableList()
            } else if (diff == maxScore) {
                for (i in 0 until 11) {
                    if (ryan[10 - i] > maxList[10 - i]) {
                        maxList = ryan.toMutableList()
                        break
                    } else if (ryan[10 - i] < maxList[10 - i]) {
                        break
                    }
                }
            }
        }
    }

    fun solution(n: Int, info: IntArray): IntArray {
        val temp = MutableList(11) { 0 }
        ryanScore(0, temp, n, info)

        return if (maxList.isEmpty()) intArrayOf(-1) else maxList.toIntArray()
    }
}