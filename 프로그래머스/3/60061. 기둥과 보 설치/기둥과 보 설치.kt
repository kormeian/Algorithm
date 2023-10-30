class Solution {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val map = Array(2) { Array(n + 2) { BooleanArray(n + 2) } }

        for (i in build_frame.indices) {
            val x = build_frame[i][0]
            val y = build_frame[i][1]
            val a = build_frame[i][2]
            val b = build_frame[i][3]

            if (b == 1) {
                when (a) {
                    0 -> if (isPossible(y, x, 0, map)) map[0][y][x] = true
                    1 -> if (isPossible(y, x, 1, map)) map[1][y][x] = true
                }
            } else {
                map[a][y][x] = false

                if (!isRemovable(y, x, a, map)) {
                    map[a][y][x] = true
                }
            }
        }
        val infoArrayList = ArrayList<IntArray>()
        for (type in map.indices) {
            for (r in map[0].indices) {
                for (c in map[0][0].indices) {
                    if (!map[type][r][c]) continue
                    infoArrayList.add(intArrayOf(c, r, type))
                }
            }
        }
        infoArrayList.sortWith { o1, o2 ->
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    o1[2] - o2[2]
                } else {
                    o1[1] - o2[1]
                }
            } else {
                o1[0] - o2[0]
            }
        }

        val answer = Array(infoArrayList.size) { IntArray(3) }
        for (i in infoArrayList.indices) {
            answer[i][0] = infoArrayList[i][0]
            answer[i][1] = infoArrayList[i][1]
            answer[i][2] = infoArrayList[i][2]
        }
        return answer
    }

    private fun isPossible(r: Int, c: Int, type: Int, map: Array<Array<BooleanArray>>): Boolean {
        when (type) {
            0 -> {
                if (r == 0) return true
                if (c > 0 && map[1][r][c - 1]) return true
                if (map[1][r][c]) return true
                if (map[0][r - 1][c]) return true
            }

            1 -> {
                if (map[0][r - 1][c]) return true
                if (map[0][r - 1][c + 1]) return true
                if (c > 0 && (map[1][r][c - 1]) && map[1][r][c + 1]) return true
            }
        }
        return false
    }

    private fun isRemovable(r: Int, c: Int, type: Int, map: Array<Array<BooleanArray>>): Boolean {
        when (type) {
            0 -> {
                if (map[0][r + 1][c] && !isPossible(r + 1, c, 0, map)) {
                    return false
                }
                if (c > 0 && map[1][r + 1][c - 1] && !isPossible(r + 1, c - 1, 1, map)) {
                    return false
                }
                if (map[1][r + 1][c] && !isPossible(r + 1, c, 1, map)) {
                    return false
                }
            }

            1 -> {
                if (map[0][r][c] && !isPossible(r, c, 0, map)) {
                    return false
                }
                if (map[0][r][c + 1] && !isPossible(r, c + 1, 0, map)) {
                    return false
                }
                if (c > 0 && map[1][r][c - 1] && !isPossible(r, c - 1, 1, map)) {
                    return false
                }
                if (map[1][r][c + 1] && !isPossible(r, c + 1, 1, map)) {
                    return false
                }
            }
        }
        return true
    }
}