import kotlin.math.abs

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size)
        for (i in places.indices) {
            if (isSafe(places[i])) {
                answer[i] = 1
            } else {
                answer[i] = 0
            }
        }
        return answer
    }

    private fun isSafe(place: Array<String>): Boolean {
        val people = mutableListOf<Pair<Int, Int>>()
        for (i in place.indices) {
            for (j in place[i].indices) {
                if (place[i][j] == 'P') {
                    people.add(Pair(i, j))
                }
            }
        }
        for (i in people.indices) {
            for (j in i + 1 until people.size) {
                if (manhattanDistance(people[i], people[j]) <= 2) {
                    if (people[i].first == people[j].first) {
                        if (place[people[i].first][people[i].second + 1] != 'X') {
                            return false
                        }
                    } else if (people[i].second == people[j].second) {
                        if (place[people[i].first + 1][people[i].second] != 'X') {
                            return false
                        }
                    } else {
                        val x1 = people[i].first
                        val y1 = people[i].second
                        val x2 = people[j].first
                        val y2 = people[j].second
                        if (place[x1][y2] != 'X' || place[x2][y1] != 'X') {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    private fun manhattanDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
        return abs(p1.first - p2.first) + abs(p1.second - p2.second)
    }
}