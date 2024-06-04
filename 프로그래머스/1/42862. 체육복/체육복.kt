class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostList = lost.sorted().toMutableList()
        val reserveList = reserve.sorted().toMutableList()

        reserveList.intersect(lostList.toSet()).forEach {
            lostList.remove(it)
            reserveList.remove(it)
        }

        for (r in reserveList) {
            when {
                r - 1 in lostList -> lostList.remove(r - 1)
                r + 1 in lostList -> lostList.remove(r + 1)
            }
        }
        return n - lostList.size
    }
}