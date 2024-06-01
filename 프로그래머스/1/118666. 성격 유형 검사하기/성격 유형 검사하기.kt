class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val scores = mutableMapOf<Char, Int>().withDefault { 0 }

        val choiceToScore = mapOf(
            1 to 3, 2 to 2, 3 to 1,
            4 to 0,
            5 to 1, 6 to 2, 7 to 3
        )

        for (i in survey.indices) {
            val choice = choices[i]
            val (disagreeType, agreeType) = survey[i].toCharArray()

            if (choice < 4) {
                scores[disagreeType] = scores.getValue(disagreeType) + choiceToScore.getValue(choice)
            } else if (choice > 4) {
                scores[agreeType] = scores.getValue(agreeType) + choiceToScore.getValue(choice)
            }
        }

        val result = StringBuilder()

        result.append(if (scores.getValue('R') >= scores.getValue('T')) 'R' else 'T')
        result.append(if (scores.getValue('C') >= scores.getValue('F')) 'C' else 'F')
        result.append(if (scores.getValue('J') >= scores.getValue('M')) 'J' else 'M')
        result.append(if (scores.getValue('A') >= scores.getValue('N')) 'A' else 'N')

        return result.toString()
    }
}
