class Solution {
    private val parent = IntArray(2501) { it }
    private val value = Array(2501) { "" }
    private val result = mutableListOf<String>()

    fun solution(commands: Array<String>): Array<String> {
        for (command in commands) {
            val parts = command.split(" ")
            when (parts[0]) {
                "UPDATE" -> update(parts)
                "MERGE" -> merge(parts)
                "UNMERGE" -> unMerge(parts)
                "PRINT" -> print(parts)
            }
        }
        return result.toTypedArray()
    }

    private fun find(a: Int): Int {
        return if (parent[a] == a) a else {
            parent[a] = find(parent[a])
            parent[a]
        }
    }

    private fun union(a: Int, b: Int) {
        val parent1 = find(a)
        val parent2 = find(b)
        if (parent1 != parent2) parent[parent2] = parent1
    }

    private fun convertToNum(x: Int, y: Int): Int {
        return 50 * (x - 1) + y
    }

    private fun update(parts: List<String>) {
        if (parts.size == 3) {
            val oldValue = parts[1]
            val newValue = parts[2]
            for (i in 1..2500) {
                if (this.value[i] == oldValue) this.value[i] = newValue
            }
        } else {
            val r = parts[1].toInt()
            val c = parts[2].toInt()
            val newValue = parts[3]
            val num = convertToNum(r, c)
            value[find(num)] = newValue
        }
    }

    private fun merge(parts: List<String>) {
        val r1 = parts[1].toInt()
        val c1 = parts[2].toInt()
        val r2 = parts[3].toInt()
        val c2 = parts[4].toInt()
        val num1 = convertToNum(r1, c1)
        val num2 = convertToNum(r2, c2)
        val parent1 = find(num1)
        val parent2 = find(num2)
        if (parent1 != parent2) {
            val mergeValue = value[parent1].ifBlank { value[parent2] }
            value[parent1] = ""
            value[parent2] = ""
            union(parent1, parent2)
            value[parent1] = mergeValue
        }
    }

    private fun unMerge(parts: List<String>) {
        val r = parts[1].toInt()
        val c = parts[2].toInt()
        val num = convertToNum(r, c)
        val root = find(num)
        val mergeValue = value[root]
        value[root] = ""
        value[num] = mergeValue
        val deleteList = mutableListOf<Int>()
        for (i in 1..2500) {
            if (find(i) == root) deleteList.add(i)
        }
        for (i in deleteList) parent[i] = i
    }

    private fun print(parts: List<String>) {
        val r = parts[1].toInt()
        val c = parts[2].toInt()
        val num = convertToNum(r, c)
        val root = find(num)
        result.add(value[root].ifBlank { "EMPTY" })
    }
}