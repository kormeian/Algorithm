class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        answer += "ICN"
        val visited = BooleanArray(tickets.size) { false }
        val sortedTickets = tickets.sortedWith(compareBy({ it[0] }, { it[1] }))
        fun dfs(start: String, depth: Int): Boolean {
            if (depth == tickets.size) {
                return true
            }
            for (i in sortedTickets.indices) {
                if (sortedTickets[i][0] == start && !visited[i]) {
                    visited[i] = true
                    answer += sortedTickets[i][1]
                    if (dfs(sortedTickets[i][1], depth + 1)) {
                        return true
                    }
                    visited[i] = false
                    answer = answer.dropLast(1).toTypedArray()
                }
            }
            return false
        }
        dfs("ICN", 0)
        return answer
    }
}