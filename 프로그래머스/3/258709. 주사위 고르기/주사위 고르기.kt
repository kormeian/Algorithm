
class Solution {
    fun solution(dice: Array<IntArray>): IntArray {
        val map = HashMap<Int, ArrayList<Int>>()
        val n = dice.size
        val combinations = combinations(n, n / 2)

        for (aCombination in combinations) {
            val bCombination = (0 until n).filter { it !in aCombination }

            val a = ArrayList<Int>()
            val b = ArrayList<Int>()
            val products = product(6, n / 2)
            for (product in product(6, n / 2)) {
                a.add(aCombination.zip(product).sumOf { (i, j) -> dice[i][j] })
                b.add(bCombination.zip(product).sumOf { (i, j) -> dice[i][j] })
            }
            b.sort()

            val wins = a.sumOf { num ->
                leftmostBinarySearch(b, num).let {
                    if (it < 0) -it - 1 else it
                }
            }
            map[wins] = ArrayList(aCombination)
        }

        val maxKey = map.keys.maxOrNull() ?: 0

        return map[maxKey]?.map { it + 1 }?.toIntArray() ?: intArrayOf()
    }

    private fun leftmostBinarySearch(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (list[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun combinations(n: Int, k: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val combination = ArrayList<Int>()
        fun search(start: Int) {
            if (combination.size == k) {
                result.add(ArrayList(combination))
            } else {
                for (i in start until n) {
                    combination.add(i)
                    search(i + 1)
                    combination.removeAt(combination.lastIndex)
                }
            }
        }
        search(0)
        return result
    }

    private fun product(n: Int, k: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val product = ArrayList<Int>()
        fun generate(index: Int) {
            if (index == k) {
                result.add(ArrayList(product))
            } else {
                for (i in 0 until n) {
                    product.add(i)
                    generate(index + 1)
                    product.removeAt(product.lastIndex)
                }
            }
        }
        generate(0)
        return result
    }
}