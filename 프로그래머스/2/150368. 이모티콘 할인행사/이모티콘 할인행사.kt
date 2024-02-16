class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val discounts = arrayOf(10, 20, 30, 40)
        val n = emoticons.size
        var maxSubscribers = 0
        var maxSales = 0

        fun dfs(idx: Int, discount: IntArray) {
            if (idx == n) {
                var subscribers = 0
                var sales = 0
                for (user in users) {
                    var userSales = 0
                    for (i in 0 until n) {
                        val price = emoticons[i] * (100 - discount[i]) / 100
                        if (discount[i] >= user[0]) {
                            userSales += price
                        }
                    }
                    if (userSales >= user[1]) {
                        subscribers++
                    } else {
                        sales += userSales
                    }
                }
                if (subscribers > maxSubscribers || (subscribers == maxSubscribers && sales > maxSales)) {
                    maxSubscribers = subscribers
                    maxSales = sales
                }
                return
            }
            for (d in discounts) {
                discount[idx] = d
                dfs(idx + 1, discount)
            }
        }

        dfs(0, IntArray(n))
        return intArrayOf(maxSubscribers, maxSales)
    }
}