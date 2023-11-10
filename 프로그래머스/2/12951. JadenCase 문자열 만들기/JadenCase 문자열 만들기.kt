import java.util.*

class Solution {
    fun solution(s: String): String {
        return s.lowercase(Locale.getDefault())
            .split(" ")
            .joinToString(" ") { string ->
                string.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
    }
}