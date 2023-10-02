class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = HashMap<String, Int>()
        val list = ArrayList<Pair<Int, Int>>()
        for (i in genres.indices) {
            map[genres[i]] = map.getOrDefault(genres[i], 0) + plays[i]
        }
        for (i in genres.indices) {
            list.add(Pair(i, plays[i]))
        }
        list.sortWith(Comparator { o1, o2 ->
            if (o1.second == o2.second) {
                o1.first - o2.first
            } else {
                o2.second - o1.second
            }
        })
        val list2 = ArrayList<Pair<String, Int>>()
        for (i in map) {
            list2.add(Pair(i.key, i.value))
        }
        list2.sortWith(Comparator { o1, o2 ->
            o2.second - o1.second
        })
        val list3 = ArrayList<Int>()
        for (i in list2) {
            var cnt = 0
            for (j in list) {
                if (cnt == 2) {
                    break
                }
                if (genres[j.first] == i.first) {
                    list3.add(j.first)
                    cnt++
                }
            }
        }
        return list3.toIntArray()
    }
}