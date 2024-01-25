import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carMap = mutableMapOf<String, MutableList<LocalTime>>()
        val result = mutableMapOf<String, Int>()

        records.forEach { record ->
            val (time, carNumber, status) = record.split(" ")
            carMap.getOrPut(carNumber) { mutableListOf() }.add(LocalTime.parse(time))
        }

        carMap.forEach { (carNumber, times) ->
            var totalMinutes = 0
            for (i in times.indices step 2) {
                val inTime = times[i]
                val outTime = if (i + 1 < times.size) times[i + 1] else LocalTime.of(23, 59)
                totalMinutes += ChronoUnit.MINUTES.between(inTime, outTime).toInt()
            }

            val fee = if (totalMinutes <= fees[0]) fees[1]
            else fees[1] + ceil((totalMinutes - fees[0]).toDouble() / fees[2]).toInt() * fees[3]

            result[carNumber] = fee
        }

        return result.toSortedMap().values.toIntArray()
    }
}