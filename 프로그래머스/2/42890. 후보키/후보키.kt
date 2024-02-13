class Solution {
    private lateinit var table: Array<Array<String>>
    private var colSize: Int = 0
    private var rowSize: Int = 0
    private val keys: HashSet<HashSet<Int>> = HashSet()

    fun solution(relation: Array<Array<String>>): Int {
        table = relation
        rowSize = relation.size
        colSize = relation[0].size

        for (i in 1..colSize) {
            makeSet(HashSet(), 0, i)
        }

        return keys.size
    }

    private fun makeSet(set: HashSet<Int>, idx: Int, size: Int) {
        if (set.size == size) {
            check(set)
            return
        }

        for (i in idx until colSize) {
            val newSet = HashSet(set)
            newSet.add(i)
            makeSet(newSet, i + 1, size)
        }
    }

    private fun check(set: HashSet<Int>) {
        for (key in keys) {
            if (set.containsAll(key)) {
                return
            }
        }

        val tuples: HashSet<String> = HashSet()
        for (i in 0 until rowSize) {
            val sb = StringBuilder()
            for (j in set) {
                sb.append(table[i][j])
            }
            tuples.add(sb.toString())
        }

        if (tuples.size == rowSize) {
            keys.add(set)
        } 
    }
}