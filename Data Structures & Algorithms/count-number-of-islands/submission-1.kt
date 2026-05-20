class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if(grid.isEmpty()) return 0

        val row = grid.size
        val col = grid[0].size

        var islandCount = 0

        for(r in 0 until row) {
            for(c in 0 until col) {
                if(grid[r][c] == '1') {
                    islandCount++
                    dfs(grid, r, c)
                }
            }
        }
        return islandCount
    }

    fun dfs(grid: Array<CharArray>, r: Int, c:Int) {
        val row = grid.size
        val col = grid[0].size

        if(r !in 0 until row || c !in 0 until col || grid[r][c] == '0') {
            return
        }

        grid[r][c] = '0'

        dfs(grid, r+1, c)
        dfs(grid, r-1, c)
        dfs(grid, r, c+1)
        dfs(grid, r, c-1)
    }
}
