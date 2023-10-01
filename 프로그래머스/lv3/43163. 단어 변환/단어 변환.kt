import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        return bfs(begin, target, words)
    }

    private fun canChange(word1: String, word2: String): Boolean {
        var count = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i]) {
                count++
            }
        }
        return count == 1
    }

    private fun bfs(begin: String, target: String, words: Array<String>): Int {
        val queue: ArrayDeque<Node> = ArrayDeque()
        queue.add(Node(begin, 0))
        if (words.contains(target).not()) {
            return 0
        }
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            words.forEach {
                if (canChange(cur.word, it)) {
                    if (it == target) {
                        return cur.count + 1
                    }
                    queue.add(Node(it, cur.count + 1))
                }
            }
        }
        return 0
    }

    class Node(val word: String, val count: Int)
}