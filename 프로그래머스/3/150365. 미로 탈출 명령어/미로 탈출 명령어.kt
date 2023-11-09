import kotlin.math.abs

class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        val minDist = getDistance(x, y, r, c)
        if (minDist > k || (k - minDist) % 2 != 0) return "impossible"
        val dir:MutableList<Pair<String,Pair<Int, Int>>> = mutableListOf(
            Pair("d", Pair(1, 0)),
            Pair("l", Pair(0, -1)),
            Pair("r", Pair(0, 1)),
            Pair("u", Pair(-1, 0))
        )
        val sb = StringBuilder()
        fun dfs(x:Int, y:Int, distance:Int) : String{
            if (distance == k) return sb.toString()
            for (i in 0 until 4) {
                val (dx, dy) = dir[i].second
                val nx = x + dx
                val ny = y + dy
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue
                if (getDistance(nx, ny, r, c) > k - distance) continue
                sb.append(dir[i].first)
                return dfs(nx, ny, distance + 1)
            }
            return ""
        }
        return dfs(x, y, 0)
    }

    private fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return abs(x1 - x2) + abs(y1 - y2)
    }
}