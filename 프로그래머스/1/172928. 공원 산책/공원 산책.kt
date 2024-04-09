class Solution {
     fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var curY = 0
        var curX = 0
        val moveY = mapOf('N' to -1, 'S' to 1, 'W' to 0, 'E' to 0)
        val moveX = mapOf('N' to 0, 'S' to 0, 'W' to -1, 'E' to 1)

        for (i in park.indices) {
            for (j in park[i].indices) {
                if (park[i][j] == 'S') {
                    curY = i
                    curX = j
                }
            }
        }

        for (route in routes) {
            val dir = route[0]
            val cnt = route.substring(2).toInt()
            var max = cnt

            for (i in 1..cnt) {
                val newY = curY + moveY[dir]!! * i
                val newX = curX + moveX[dir]!! * i

                if (newY < 0 || newX < 0 || newY >= park.size || newX >= park[0].length || park[newY][newX] == 'X') {
                    max = 0
                    break
                }
            }

            curY += moveY[dir]!! * max
            curX += moveX[dir]!! * max
        }

        return intArrayOf(curY, curX)
    }
}