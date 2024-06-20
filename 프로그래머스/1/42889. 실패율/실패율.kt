class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val playersAtStage = IntArray(N + 2)
        for (stage in stages) {
            playersAtStage[stage]++
        }

        val failureRates = DoubleArray(N + 1)
        var players = stages.size
        for (stage in 1..N) {
            if (playersAtStage[stage] == 0) {
                failureRates[stage] = 0.0
            } else {
                failureRates[stage] = playersAtStage[stage].toDouble() / players
                players -= playersAtStage[stage]
            }
        }

        val stagesWithFailureRates = (1..N).map { it to failureRates[it] }.toMutableList()
        stagesWithFailureRates.sortWith(compareByDescending<Pair<Int, Double>> { it.second }.thenBy { it.first })

        return stagesWithFailureRates.map { it.first }.toIntArray()
    }
}