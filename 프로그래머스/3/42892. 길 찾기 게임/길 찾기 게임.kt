class Solution {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val root = makeTree(nodeinfo)
        val preorder = preorder(root)
        val postorder = postorder(root)
        return arrayOf(preorder.toIntArray(), postorder.toIntArray())
    }

    private class Node(
        val index: Int,
        val x: Int,
        val y: Int
    ) {
        var left: Node? = null
        var right: Node? = null
        fun add(node: Node) {
            if (node.x < x) {
                if (left == null) {
                    left = node
                } else {
                    left!!.add(node)
                }
            } else {
                if (right == null) {
                    right = node
                } else {
                    right!!.add(node)
                }
            }
        }
    }

    private fun makeTree(nodeinfo: Array<IntArray>): Node {
        var nodes = nodeinfo.mapIndexed { index, ints -> Node(index + 1, ints[0], ints[1]) }
        nodes = nodes.sortedWith(compareBy({ -it.y }, { it.x }))
        val root = nodes[0]
        for (i in 1 until nodes.size) {
            root.add(nodes[i])
        }
        return root
    }

    private fun preorder(node: Node): List<Int> {
        val list = mutableListOf<Int>()
        list.add(node.index)
        if (node.left != null) {
            list.addAll(preorder(node.left!!))
        }
        if (node.right != null) {
            list.addAll(preorder(node.right!!))
        }
        return list
    }

    private fun postorder(node: Node): List<Int> {
        val list = mutableListOf<Int>()
        if (node.left != null) {
            list.addAll(postorder(node.left!!))
        }
        if (node.right != null) {
            list.addAll(postorder(node.right!!))
        }
        list.add(node.index)
        return list
    }
}