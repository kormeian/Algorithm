class Solution {
    fun solution(new_id: String): String {
        var answer = new_id.toLowerCase()
            .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
            .replace("[.]+".toRegex(), ".")
            .removePrefix(".").removeSuffix(".")
        if (answer.isEmpty()) answer = "a"
        if (answer.length >= 16) {
            answer = answer.substring(0, 15)
            answer = answer.removeSuffix(".")
        }
        while (answer.length <= 2) {
            answer += answer[answer.length - 1]
        }

        return answer
    }
}