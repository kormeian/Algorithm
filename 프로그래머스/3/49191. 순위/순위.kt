class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val graph = Array(n + 1) { BooleanArray(n + 1) { false } }
        for (result in results) {
            graph[result[0]][result[1]] = true
        }
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true
                    }
                }
            }
        }
        for (i in 1..n) {
            var count = 0
            for (j in 1..n) {
                if (graph[i][j] || graph[j][i]) {
                    count++
                }
            }
            if (count == n - 1) {
                answer++
            }
        }
        return answer
    }
}