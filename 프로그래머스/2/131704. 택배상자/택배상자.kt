class Solution {
    fun solution(order: IntArray): Int {
        val orderMap = HashMap<Int, Int>()
        for (i in order.indices) {
            orderMap[order[i]] = i + 1
        }

        val boxes = ArrayDeque<Int>()
        for (i in 1..order.size) {
            boxes.add(i)
        }

        val auxiliaryBelt = ArrayDeque<Int>()
        var count = 0
        var currentOrder = 1

        while (boxes.isNotEmpty()) {
            val box = boxes.removeFirst()

            if (orderMap[box] == currentOrder) {
                count++
                currentOrder++

                while (auxiliaryBelt.isNotEmpty() && orderMap[auxiliaryBelt.last()] == currentOrder) {
                    auxiliaryBelt.removeLast()
                    count++
                    currentOrder++
                }
            } else {
                auxiliaryBelt.add(box)
            }
        }

        return count
    }
}