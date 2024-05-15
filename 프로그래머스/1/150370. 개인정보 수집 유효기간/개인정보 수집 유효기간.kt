class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val termMap = terms.associate { it.split(" ")[0] to it.split(" ")[1].toInt() }
        val todayDate = convertToDate(today)
        val answer = mutableListOf<Int>()

        privacies.forEachIndexed { index, privacy ->
            val split = privacy.split(" ")
            val privacyDate = convertToDate(split[0])
            val term = termMap[split[1]]!!
            if (privacyDate.plusMonths(term) <= todayDate) {
                answer.add(index + 1)
            }
        }

        return answer.toIntArray()
    }

    private fun convertToDate(date: String): Date {
        val split = date.split(".")
        return Date(split[0].toInt(), split[1].toInt(), split[2].toInt())
    }

    private data class Date(val year: Int, val month: Int, val day: Int) {
         fun plusMonths(months: Int): Date {
            var newYear = year
            var newMonth = month + months
            while (newMonth > 12) {
                newYear++
                newMonth -= 12
            }
            return Date(newYear, newMonth, day)
        }

        operator fun compareTo(other: Date): Int {
            return when {
                year != other.year -> year - other.year
                month != other.month -> month - other.month
                else -> day - other.day
            }
        }
    }
}