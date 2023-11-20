class Solution {
    fun solution(elements: IntArray): Int {
        val arr = IntArray(elements.size * 2)
        for (i in arr.indices) {
            arr[i] = elements[i % elements.size]
        }
        val set = mutableSetOf<Int>()
        for (i in 1..elements.size) {
            for (j in 0..elements.size) {
                set.add(arr.sliceArray(j until j + i).sum())
            }
        }
        return set.size
    }
}