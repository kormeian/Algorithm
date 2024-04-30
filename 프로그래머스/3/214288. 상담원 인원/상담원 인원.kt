import java.util.*


class Solution {
    fun solution(k: Int, n: Int, reqs: Array<IntArray>): Int {
        fun calculateWaitingTimeForType(waitings: List<Pair<Int, Int>>, n: Int): Int {
            var totalWaitTime = 0
            val counselList = PriorityQueue<Int>()
            repeat(n) { counselList.offer(0) }
            for ((start, duration) in waitings) {
                val prevEnd = counselList.poll()
                if (start > prevEnd) {
                    counselList.offer(duration)
                } else {
                    val waitTime = prevEnd - start
                    totalWaitTime += waitTime
                    counselList.offer(duration + waitTime)
                }
            }
            return totalWaitTime
        }

        var result = Int.MAX_VALUE
        val requestsByType = Array(k) { mutableListOf<Pair<Int, Int>>() }
        for (req in reqs) {
            requestsByType[req[2] - 1].add(Pair(req[0], req[0] + req[1]))
        }

        val mentorAssignments = mutableSetOf<List<Int>>()
        for (comb in combinationsWithReplacement((1..n - k + 2).toList(), k)) {
            if (comb.sum() == n) {
                for (perm in comb.permutations()) {
                    mentorAssignments.add(perm)
                }
            }
        }

        for (case in mentorAssignments) {
            var time = 0
            for (i in 0 until k) {
                time += calculateWaitingTimeForType(requestsByType[i], case[i])
            }
            result = minOf(result, time)
        }

        return result
    }

    private fun <T> List<T>.permutations(): List<List<T>> {
        if (this.size == 1) return listOf(this)
        val perms = mutableListOf<List<T>>()
        val toInsert = this[0]
        for (perm in this.drop(1).permutations()) {
            for (i in 0..perm.size) {
                val newPerm = ArrayList(perm)
                newPerm.add(i, toInsert)
                perms.add(newPerm)
            }
        }
        return perms
    }

    private fun <T> combinationsWithReplacement(elements: List<T>, k: Int): List<List<T>> {
        if (k == 0) return listOf(emptyList())
        if (elements.isEmpty()) return emptyList()
        val element = elements.first()
        val rest = elements.drop(1)
        return (0..k).flatMap { i ->
            combinationsWithReplacement(rest, k - i).map { combination -> List(i) { element } + combination }
        }
    }
}