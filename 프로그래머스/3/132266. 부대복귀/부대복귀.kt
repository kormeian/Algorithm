class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val graph = ArrayList<ArrayList<Int>>()
        for (i in 0..n) {
            graph.add(ArrayList())
        }
        for (road in roads) {
            graph[road[0]].add(road[1])
            graph[road[1]].add(road[0])
        }
        val distance = IntArray(n + 1) { -1 }
        val queue = ArrayDeque<Int>()
        queue.add(destination)
        distance[destination] = 0
        while (queue.isNotEmpty()) {
            val now = queue.removeFirst()
            for (next in graph[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1
                    queue.add(next)
                }
            }
        }

        sources.forEach {
            answer += distance[it]
        }
        return answer
    }
}