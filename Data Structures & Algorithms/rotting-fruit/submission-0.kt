class Solution {

    fun orangesRotting(grid: Array<IntArray>): Int {

        val rows = grid.size
        val cols = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        var fresh = 0

        // Initial scan
        for (r in 0 until rows) {
            for (c in 0 until cols) {

                when (grid[r][c]) {

                    1 -> fresh++

                    2 -> queue.addLast(Pair(r, c))
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) return 0

        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        var minutes = 0

        while (queue.isNotEmpty()) {

            val size = queue.size
            var rottenThisMinute = false

            repeat(size) {

                val (r, c) = queue.removeFirst()

                for (dir in directions) {

                    val nr = r + dir[0]
                    val nc = c + dir[1]

                    if (nr !in 0 until rows ||
                        nc !in 0 until cols ||
                        grid[nr][nc] != 1
                    ) {
                        continue
                    }

                    // rot orange
                    grid[nr][nc] = 2

                    fresh--

                    queue.addLast(Pair(nr, nc))

                    rottenThisMinute = true
                }
            }

            if (rottenThisMinute) {
                minutes++
            }
        }

        return if (fresh == 0) minutes else -1
    }
}