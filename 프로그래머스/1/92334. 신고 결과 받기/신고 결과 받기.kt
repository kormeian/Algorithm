class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val map = mutableMapOf<String, MutableSet<String>>()
        val reportMap = mutableMapOf<String, Int>()
        for (id in id_list) {
            map[id] = mutableSetOf()
            reportMap[id] = 0
        }
        for (r in report) {
            val split = r.split(" ")
            map[split[0]]?.add(split[1])
        }
        for (id in id_list) {
            for (r in map[id]!!) {
                reportMap[r] = reportMap[r]!! + 1
            }
        }
        for (id in id_list) {
            var count = 0
            for (r in map[id]!!) {
                if (reportMap[r]!! >= k) {
                    count++
                }
            }
            answer[id_list.indexOf(id)] = count
        }
        return answer
    }
}