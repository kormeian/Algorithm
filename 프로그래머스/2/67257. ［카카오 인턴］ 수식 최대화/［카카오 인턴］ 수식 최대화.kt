import kotlin.math.abs

class Solution { 
    fun solution(expression: String): Long {
        val numbers = mutableListOf<Long>()
        val operators = mutableListOf<Char>()
        var number = ""
        for (char in expression) {
            if (char.isDigit()) {
                number += char
            } else {
                numbers.add(number.toLong())
                number = ""
                operators.add(char)
            }
        }
        numbers.add(number.toLong())

        val operatorSet = operators.distinct()
        val permutations = permute(operatorSet)

        var max = 0L
        for (permutation in permutations) {
            val tempNumbers = numbers.toMutableList()
            val tempOperators = operators.toMutableList()
            for (operator in permutation) {
                var i = 0
                while (i < tempOperators.size) {
                    if (tempOperators[i] == operator) {
                        val result = calculate(tempNumbers.removeAt(i), tempNumbers.removeAt(i), operator)
                        tempNumbers.add(i, result)
                        tempOperators.removeAt(i)
                        i--
                    }
                    i++
                }
            }
            max = max.coerceAtLeast(abs(tempNumbers[0]))
        }
        return max
    }

    private fun calculate(a: Long, b: Long, operator: Char): Long {
        return when (operator) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }

    private fun permute(list: List<Char>): List<List<Char>> {
        if (list.size == 1) return listOf(list)
        val perms = mutableListOf<List<Char>>()
        val toInsert = list[0]
        for (perm in permute(list.drop(1))) {
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, toInsert)
                perms.add(newPerm)
            }
        }
        return perms
    }
}