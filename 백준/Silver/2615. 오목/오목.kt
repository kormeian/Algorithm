val map = Array(21) { IntArray(21) }
val tmp = Array(21) { Array(21) { IntArray(4) } }
val dir = arrayOf(
    intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(-1, 1)
)

fun main(args: Array<String>) {
    readInput()
    println(solution())
}

fun readInput() {
    for (i in 1..19) {
        val str = readln().split(" ").map { it.toInt() }
        for (j in 1..19) {
            map[i][j] = str[j - 1]
        }
    }
}

fun solution(): String {
    for (j in 1..19) {
        for (i in 1..19) {
            if (map[i][j] != 0) {
                for (d in 0..3) {
                    if (tmp[i][j][d] == 0 && checkWin(i, j, d, map[i][j]) == 5) {
                        return "${map[i][j]}\n$i $j"
                    }
                }
            }
        }
    }
    return "0"
}

fun checkWin(x: Int, y: Int, k: Int, color: Int): Int {
    val nx = x + dir[k][0]
    val ny = y + dir[k][1]

    return if (map[nx][ny] == color) {
        checkWin(nx, ny, k, color) + 1.also { tmp[nx][ny][k] = it }
    } else 1
}