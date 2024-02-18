class Solution {
    fun solution(name: String): Int {
        var answer = 0
        val nameLength = name.length
        var move = nameLength - 1

        for (i in 0 until nameLength) {
            val upDown = (name[i] - 'A').coerceAtMost('Z' - name[i] + 1)
            answer += upDown

            var nextIndex = i + 1
            while (nextIndex < nameLength && name[nextIndex] == 'A') {
                nextIndex++
            }

            move = move.coerceAtMost(
                i + nameLength - nextIndex + i.coerceAtMost(nameLength - nextIndex)
            ) 
        }

        answer += move
        return answer
    }
}