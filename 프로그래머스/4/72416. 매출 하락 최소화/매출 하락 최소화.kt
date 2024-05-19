import kotlin.math.min

class Solution {
    private val graph = mutableMapOf<Int, MutableList<Int>>()
    private lateinit var sales: IntArray
    private lateinit var dp: Array<IntArray>

    private fun dfs(node: Int) {
        dp[node][0] = 0
        dp[node][1] = sales[node]
        if (!graph.containsKey(node)) return
        var min = Int.MAX_VALUE
        for (child in graph[node]!!) {
            dfs(child)
            if (dp[child][0] < dp[child][1]) {
                dp[node][0] += dp[child][0]
                dp[node][1] += dp[child][0]
                min = min(min, dp[child][1] - dp[child][0])
            } else {
                dp[node][0] += dp[child][1]
                dp[node][1] += dp[child][1]
                min = 0
            }
        }
        dp[node][0] += min
    }

    fun solution(sales: IntArray, links: Array<IntArray>): Int {
        this.sales = intArrayOf(0) + sales
        dp = Array(this.sales.size) { IntArray(2) }
        for (link in links) {
            val (parent, child) = link
            graph.getOrPut(parent) { mutableListOf() }.add(child)
        }

        dfs(1)
        return min(dp[1][0], dp[1][1])
    }
}