class Solution {
    private val map = mutableMapOf<String, ArrayList<Int>>()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        info.forEach { dfs(it.split(" "), "", 0) }
        map.values.map { it.sort() }

        query.forEachIndexed { index, s ->
            val split = s.split(" and ", " ")
            val string = split.subList(0, 4).joinToString("")
            val score = split[4].toInt()
            val list = map.getOrDefault(string, arrayListOf())
            answer[index] = if (list.isEmpty()) 0 else binarySearch(list, score)
        }
        return answer
    }

    private fun dfs(split: List<String>, string: String, index: Int) {
        if (index == 4) {
            val score = split[4].toInt()
            map[string] = map.getOrDefault(string, arrayListOf()).apply { add(score) }
        } else {
            dfs(split, "$string${split[index]}", index + 1)
            dfs(split, "$string-", index + 1)
        }
    }

    private fun binarySearch(list: List<Int>, score: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid] < score) left = mid + 1
            else right = mid - 1
        }
        return list.size - left
    }
}