class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val answer = IntArray(targets.size)

        for ((i, word) in targets.withIndex()) {
            var times = 0

            for (char in word) {
                var flag = false
                var time = 101

                for (key in keymap) {
                    if (char in key) {
                        time = minOf(key.indexOf(char) + 1, time)
                        flag = true
                    }
                }

                if (!flag) {
                    times = -1
                    break
                }

                times += time
            }

            answer[i] = times
        }

        return answer
    }
}