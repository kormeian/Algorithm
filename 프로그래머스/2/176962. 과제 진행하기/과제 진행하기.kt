class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val answer = mutableListOf<Pair<String, Int>>()
        plans.map {
            Triple(it[0], it[1].split(":").let { (h, m) -> h.toInt() * 60 + m.toInt() }, it[2].toInt())
        }.sortedBy { it.second }.forEach { (name, start, playtime) ->
            answer.forEachIndexed { index, plan ->
                if (plan.second > start) answer[index] = Pair(plan.first, plan.second + playtime)
            }
            answer.add(Pair(name, start + playtime))
        }
        return answer.sortedBy { it.second }.map { it.first }.toTypedArray()
    }
}