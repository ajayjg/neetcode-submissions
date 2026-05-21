class Solution {

    fun islandsAndTreasure(grid: Array<IntArray>): Unit {

        val rows = grid.size
        val cols = grid[0].size

        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()

        // Add all gates/treasures
        for (r in 0 until rows) {
            for (c in 0 until cols) {

                if (grid[r][c] == 0) {
                    queue.addLast(Pair(r, c))
                }
            }
        }

        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {

            val (r, c) = queue.removeFirst()

            for (dir in directions) {

                val nr = r + dir[0]
                val nc = c + dir[1]

                // boundary check
                if (nr !in 0 until rows || nc !in 0 until cols) {
                    continue
                }

                // only process INF cells
                if (grid[nr][nc] != Int.MAX_VALUE) {
                    continue
                }

                // distance update
                grid[nr][nc] = grid[r][c] + 1

                queue.addLast(Pair(nr, nc))
            }
        }
    }
}