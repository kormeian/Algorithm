class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 1
        arr.forEach {
            answer = lcm(answer, it)
        }
        return answer
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)
}