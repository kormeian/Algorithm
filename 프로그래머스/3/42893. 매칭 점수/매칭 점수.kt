import java.util.regex.Pattern

class Solution {
    data class WebPage(
        var name: String? = null,
        var outerCnt: Int = 0,
        var basicScore: Int = 0,
        var linkedOutPage: List<String> = listOf(),
        var score: Double = 0.0
    )

    fun solution(word: String, pages: Array<String>): Int {
        val wordLower = word.lowercase()
        val webPages = Array(pages.size) { WebPage() }

        pages.forEachIndexed { index, page ->
            var score = 0
            val lowerPage = page.lowercase()
            val dataList = mutableListOf<String>()

            val mt = Pattern.compile("(<meta property=\"og:url\" content=\"https://(\\S*)\")").matcher(lowerPage)
            while (mt.find()) {
                val name = mt.group(2).trim()
                webPages[index].name = name
            }

            val mtWord = Pattern.compile("(?<=[^a-zA-Z])($wordLower)[^a-zA-Z]").matcher(lowerPage)
            while (mtWord.find()) {
                score += 1
            }
            webPages[index].basicScore = score

            val mtLink = Pattern.compile("<a href=\"(\\S*)//(\\S*)\"").matcher(lowerPage)
            while (mtLink.find()) {
                val url = mtLink.group(2).trim()
                dataList.add(url)
            }
            webPages[index].linkedOutPage = dataList
            webPages[index].outerCnt = dataList.size
        }

        webPages.forEach { webPage ->
            webPage.linkedOutPage.forEach { url ->
                webPages.filter { it.name == url }.forEach {
                    it.score += webPage.basicScore.toDouble() / webPage.linkedOutPage.size
                }
            }
        }

        val maxWebPage = webPages.maxByOrNull { it.basicScore + it.score }
        return webPages.indexOf(maxWebPage)
    }
}