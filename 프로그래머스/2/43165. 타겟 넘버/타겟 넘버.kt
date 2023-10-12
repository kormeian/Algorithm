class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(Pair(numbers[0], 0))
        queue.add(Pair(-numbers[0], 0))
        while (queue.isNotEmpty()) {
            val (sum, index) = queue.removeFirst()
            if (index == numbers.size - 1) {
                if (sum == target) {
                    answer++
                }
                continue
            }
            queue.add(Pair(sum + numbers[index + 1], index + 1))
            queue.add(Pair(sum - numbers[index + 1], index + 1))
        }
        return answer
    }
}