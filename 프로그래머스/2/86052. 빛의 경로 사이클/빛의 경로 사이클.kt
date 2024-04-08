class Solution {
    private val dir = arrayOf(intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(0, 1))

    private fun move(r: Int, c: Int, d: Int, n: Int, m: Int): Pair<Int, Int> {
        val dx = dir[d][0]
        val dy = dir[d][1]
        return Pair((r + dx + n) % n, (c + dy + m) % m)
    }

    private fun rotate(d: Int, node: Char): Int {
        return when (node) {
            'R' -> (d + 1) % 4
            'L' -> (d + 3) % 4
            else -> d
        }
    }

    fun solution(grid: Array<String>): IntArray {
        val n = grid.size
        val m = grid[0].length
        val visited = Array(n) { Array(m) { BooleanArray(4) { false } } }
        val answer = mutableListOf<Int>()

        for (r in 0 until n) {
            for (c in 0 until m) {
                for (d in 0 until 4) {
                    if (!visited[r][c][d]) {
                        var nr = r
                        var nc = c
                        var nd = d
                        var cnt = 0
                        while (!visited[nr][nc][nd]) {
                            visited[nr][nc][nd] = true
                            cnt++
                            val moved = move(nr, nc, nd, n, m)
                            nr = moved.first
                            nc = moved.second
                            nd = rotate(nd, grid[nr][nc])
                        }
                        answer.add(cnt)
                    }
                }
            }
        }
        return answer.sorted().toIntArray()
    }
}