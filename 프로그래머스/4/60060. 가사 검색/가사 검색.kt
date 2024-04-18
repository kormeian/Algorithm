class Solution {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val answer = IntArray(queries.size)
        val root = Trie()
        val tail = Trie()

        for (word in words) {
            root.insert(word)
            tail.insert(word.reversed())
        }
        for (i in queries.indices) {
            if (queries[i][0] != '?') {
                answer[i] = root.find(queries[i])
            } else {
                answer[i] = tail.find(queries[i].reversed())
            }
        }
        return answer
    }

    private class Trie {
        val children: HashMap<Char, Trie?> = HashMap()
        val length: HashMap<Int, Int> = HashMap()

        fun insert(text: String) {
            var trie = this

            for (ch in text) {
                if (trie.children[ch] == null) {
                    trie.children[ch] = Trie()
                }
                trie.length[text.length] = trie.length.getOrDefault(text.length, 0) + 1
                trie = trie.children[ch]!!
            }
        }

        fun find(text: String): Int {
            var trie = this
            for (ch in text) {
                if (ch == '?') {
                    return trie.length.getOrDefault(text.length, 0)
                } else if (trie.children[ch] == null) {
                    return 0
                } else {
                    trie = trie.children[ch]!!
                }
            }
            return trie.length.getOrDefault(text.length, 0)
        }
    }
}