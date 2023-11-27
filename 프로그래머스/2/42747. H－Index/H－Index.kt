class Solution {
    fun solution(citations: IntArray): Int {
        return citations.sortedDescending().filterIndexed { index, i -> (index + 1) <= i }.lastIndex + 1
    }
}