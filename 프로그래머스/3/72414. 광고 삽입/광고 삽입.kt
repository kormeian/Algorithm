class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer = ""
        val playTime = stringTimeToInt(play_time)
        val advTime = stringTimeToInt(adv_time)
        val timeTable = IntArray(playTime + 1)
        for (log in logs) {
            val (start, end) = log.split("-")
            val logStart = stringTimeToInt(start)
            val logEnd = stringTimeToInt(end)
            timeTable[logStart]++
            timeTable[logEnd]--
        }
        for (i in 1..playTime) {
            timeTable[i] += timeTable[i - 1]
        }
        var maxIdx = 0
        var max = 0L
        var sum = 0L
        for (i in 0 until advTime) {
            sum += timeTable[i]
        }
        max = sum
        for (i in advTime until playTime) {
            sum += timeTable[i] - timeTable[i - advTime]
            if (sum > max) {
                max = sum
                maxIdx = i - advTime + 1
            }
        }
        return intToStringTime(maxIdx)
    }

    private fun stringTimeToInt(time: String): Int {
        val (hour, minute, second) = time.split(":")
        return hour.toInt() * 3600 + minute.toInt() * 60 + second.toInt()
    }

    private fun intToStringTime(time: Int): String {
        val hour = time / 3600
        val minute = (time % 3600) / 60
        val second = time % 60
        return "${hour.toString().padStart(2, '0')}:" +
                "${minute.toString().padStart(2, '0')}:" +
                second.toString().padStart(2, '0')
    }
}