class Solution {
    fun solution(record: Array<String>): Array<String> {
         val idToNickname = mutableMapOf<String, String>()
        val actions = mutableListOf<Pair<String, String>>()

        for (r in record) {
            val words = r.split(" ")
            val action = words[0]
            val id = words[1]

            if (action == "Enter" || action == "Change") {
                val nickname = words[2]
                idToNickname[id] = nickname
            }

            if (action == "Enter" || action == "Leave") {
                actions.add(Pair(action, id))
            }
        }

        return actions.map { (action, id) ->
            val nickname = idToNickname[id]!!
            when (action) {
                "Enter" -> "${nickname}님이 들어왔습니다."
                "Leave" -> "${nickname}님이 나갔습니다."
                else -> ""
            }
        }.toTypedArray()
    }
}