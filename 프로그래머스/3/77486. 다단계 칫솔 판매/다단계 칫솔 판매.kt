class Solution {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val answer = IntArray(enroll.size)
        val map = HashMap<String, Int>()
        for (i in enroll.indices) {
            map[enroll[i]] = i
        }
        for (i in seller.indices) {
            var money = amount[i] * 100
            while (seller[i] != "-" && money > 0) {
                answer[map[seller[i]]!!] += money - money / 10
                money /= 10
                seller[i] = referral[map[seller[i]]!!]
            }
        }
        return answer
    }
}