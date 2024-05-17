class Solution {
    private val dir = arrayOf(
        intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(1, -1),
        intArrayOf(0, -1), intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1)
    )

    fun solution(arrows: IntArray): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val edgeVisited = mutableSetOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
        var cur = Pair(0, 0)
        visited.add(cur)
        for (arrow in arrows) {
            for (i in 0 until 2) {
                val next = Pair(cur.first + dir[arrow][0], cur.second + dir[arrow][1])
                visited.add(next)
                edgeVisited.add(Pair(cur, next))
                edgeVisited.add(Pair(next, cur))
                cur = next
            }
        }
        val vertex = visited.size
        val edge = edgeVisited.size / 2
        return 1 - vertex + edge
    }
}