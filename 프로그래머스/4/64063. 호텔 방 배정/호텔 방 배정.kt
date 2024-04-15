import java.util.*

class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        val answer = LongArray(room_number.size)
        val map = TreeMap<Long, Long>()
        for (i in room_number.indices) {
            val room = room_number[i]
            if (!map.containsKey(room)) {
                map[room] = room + 1
                answer[i] = room
            } else {
                val next = find(map, room)
                map[next] = next + 1
                answer[i] = next
            }
        }
        return answer
    }

    private fun find(map: TreeMap<Long, Long>, room: Long): Long {
        val next = map[room]!!
        if (!map.containsKey(next)) {
            return next
        }
        val n = find(map, next)
        map[room] = n
        return n
    }
}