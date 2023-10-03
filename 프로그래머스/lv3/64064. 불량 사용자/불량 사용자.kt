class Solution {
    private var visited: BooleanArray? = null
    private var set: MutableSet<String> = mutableSetOf()

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        visited = BooleanArray(user_id.size)
        for (i in banned_id.indices) {
            banned_id[i] = banned_id[i].replace("*", ".")
        }
        dfs(0, "", banned_id, user_id)
        return set.size
    }

    fun dfs(
        depth: Int,
        result: String,
        banned_id: Array<String>,
        user_id: Array<String>
    ) {
        if (depth == banned_id.size) {
            var arr = result.split(" ")
            arr = arr.sorted()
            var str = ""
            arr.forEach {
                str += it
            }
            set.add(str)
            return
        }

        for (i in user_id.indices) {
            if (visited!![i] || !user_id[i].matches(banned_id[depth].toRegex())) {
                continue
            }
            visited!![i] = true
            dfs(depth + 1, "${user_id[i]} $result", banned_id, user_id)
            visited!![i] = false
        }
    }
}