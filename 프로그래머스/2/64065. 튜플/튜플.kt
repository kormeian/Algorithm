import java.util.regex.Pattern
class Solution {
    fun solution(s: String): IntArray {
        val answer = mutableListOf<Int>()
        val p = Pattern.compile("\\{((\\d+,?)+)\\}")
        val m = p.matcher(s)
        val parts = mutableListOf<List<Int>>()

        while (m.find()) {
            parts.add(m.group(1).split(",").map { it.toInt() })
        }

        parts.sortBy { it.size }

        for (part in parts) {
            for (num in part) {
                if (!answer.contains(num)) {
                    answer.add(num)
                }
            }
        }

        return answer.toIntArray()
    }
}