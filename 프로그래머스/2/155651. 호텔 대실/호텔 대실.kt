class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val timeList = mutableListOf<Pair<Int, Int>>()
        for (time in book_time) {
            val start = time[0].split(":")
            val end = time[1].split(":")
            val startHour = start[0].toInt() * 60
            val startMin = start[1].toInt()
            val endHour = end[0].toInt() * 60
            val endMin = end[1].toInt()
            timeList.add(Pair(startHour + startMin, endHour + endMin))
        }
        timeList.sortBy { it.first }
        val roomList = mutableListOf<Int>()
        for (time in timeList) {
            var isPossible = true
            for (i in roomList.indices) {
                if (time.first >= roomList[i]) {
                    roomList[i] = time.second + 10
                    isPossible = false
                    break
                }
            }
            if (isPossible) {
                roomList.add(time.second + 10)
            }
        }
        return roomList.size
    }
}