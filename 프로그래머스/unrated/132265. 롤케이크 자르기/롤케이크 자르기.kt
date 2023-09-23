class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
    val set1 = HashSet<Int>()
    val set2 = HashSet<Int>()
    val map = mutableMapOf<Int, Int>()

    topping.forEach {
        set2.add(it)
        map[it] = map.getOrDefault(it, 0) + 1
    }

    for (i in topping.indices) {
        set1.add(topping[i])
        map[topping[i]] = map.getOrDefault(topping[i], 0) - 1
        if (map.getOrDefault(topping[i], 0) <= 0)
            set2.remove(topping[i])
        if (set1.size == set2.size) answer++
        else if (set1.size > set2.size) break
    }
    return answer
    }
}