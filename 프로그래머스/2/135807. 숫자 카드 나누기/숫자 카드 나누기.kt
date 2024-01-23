import kotlin.math.max

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = arrayA.reduce(::gcd)
        val gcdB = arrayB.reduce(::gcd)

        return max(
            if (arrayA.none { it % gcdB == 0 }) gcdB else 0,
            if (arrayB.none { it % gcdA == 0 }) gcdA else 0
        )
    }

    private fun gcd(a: Int, b: Int): Int {
        var numA = a
        var numB = b
        while (numB != 0) {
            val r = numA % numB
            numA = numB
            numB = r
        }
        return numA
    }
}