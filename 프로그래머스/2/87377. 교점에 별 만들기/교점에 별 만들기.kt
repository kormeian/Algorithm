class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        val points = mutableListOf<Pair<Int, Int>>()
        for (i in line.indices) {
            for (j in i + 1 until line.size) {
                val (A,B,E) = line[i].map{it.toLong()}
                val (C,D,F) = line[j].map{it.toLong()}

                val adbc = A*D-B*C
                val bfed = B*F-E*D
                val ecaf = E*C-A*F
                if(adbc == 0L) continue
                if(bfed%adbc!=0L || ecaf%adbc!=0L) continue

                val x = (bfed/adbc).toInt()
                val y = (ecaf/adbc).toInt()

                points.add(Pair(x,y))
            }
        }
        val minX = points.minByOrNull { it.first }!!.first
        val maxX = points.maxByOrNull { it.first }!!.first
        val minY = points.minByOrNull { it.second }!!.second
        val maxY = points.maxByOrNull { it.second }!!.second
        val grid = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '.' } }
        for (point in points) {
            grid[maxY - point.second][point.first - minX] = '*'
        }
        return grid.map { it.joinToString("") }.toTypedArray()
    }
}