class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var time = 0
        val bridge = MutableList(bridge_length) { 0 }

        var idx = 0
        while (idx < truck_weights.size || bridge.sum() != 0) {
            time++
            bridge.removeAt(0)

            if (idx < truck_weights.size && bridge.sum() + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx])
                idx++
            } else {
                bridge.add(0)
            }
        }

        return time
    }
}