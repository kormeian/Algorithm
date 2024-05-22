class Solution {
    fun solution(edges: Array<IntArray>, target: IntArray): IntArray {
        val n = edges.size + 1
        var targetCnt = 0

        val tree = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            val parent = edge[0]
            val child = edge[1]
            tree[parent - 1].add(child - 1)
        }
        for (i in 0 until n) tree[i].sort()

        val passCnt = IntArray(n)
        val cnt = IntArray(n)
        val visited = BooleanArray(n)
        val leafs = mutableListOf<Int>()

        for (i in 0 until n) if (tree[i].isEmpty() && target[i] > 0) targetCnt++

        while (targetCnt > 0) {
            var node = 0
            while (tree[node].isNotEmpty()) node = tree[node][passCnt[node]++ % tree[node].size]
            cnt[node]++
            leafs.add(node)

            if (cnt[node] > target[node]) return intArrayOf(-1)
            if (!visited[node] && target[node] <= 3 * cnt[node]) {
                visited[node] = true
                targetCnt--
            }
        }

        val answer = mutableListOf<Int>()
        for (i in leafs) {
            cnt[i]--
            for (value in 1..3) {
                if (cnt[i] <= target[i] - value && target[i] - value <= 3 * cnt[i]) {
                    answer.add(value)
                    target[i] -= value
                    break
                }
            }
        }

        return answer.toIntArray()
    }
}
