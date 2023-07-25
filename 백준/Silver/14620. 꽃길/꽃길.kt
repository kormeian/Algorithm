var n = 0
var garden = Array(n) { IntArray(n) }
val dx = intArrayOf(0, 0, 1, -1, 0)
val dy = intArrayOf(0, 1, 0, 0, -1)
var min = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    garden = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    calc(0, 0, Array(n) { BooleanArray(n) })
    println(min)
}

fun calc(depth: Int, sum: Int, visited: Array<BooleanArray>) {
    if (depth == 3) {
        min = minOf(min, sum)
        return
    }
    for (i in 1 until n - 1) {
        for (j in 1 until n - 1) {
            var isPossible = true
            var tmp = 0
            for (k in 0..4) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (visited[nx][ny]) {
                    isPossible = false
                    break
                }
                tmp += garden[nx][ny]
            }
            if (isPossible) {
                for (k in 0..4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    visited[nx][ny] = true
                }
                calc(depth + 1, sum + tmp, visited)
                for (k in 0..4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    visited[nx][ny] = false
                }
            }
        }
    }
}