class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty() || board[0].isEmpty()) return

        val rows = board.size
        val cols = board[0].size

        // Step 1: Mark all 'O's connected to border as safe ('T')
        // Top and Bottom borders
        for (j in 0 until cols) {
            if (board[0][j] == 'O') dfs(board, 0, j)
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j)
        }
        
        // Left and Right borders
        for (i in 0 until rows) {
            if (board[i][0] == 'O') dfs(board, i, 0)
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1)
        }

        // Step 2: Flip all remaining 'O' to 'X' and restore 'T' back to 'O'
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                when (board[i][j]) {
                    'O' -> board[i][j] = 'X'
                    'T' -> board[i][j] = 'O'
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != 'O') {
            return
        }

        board[i][j] = 'T'  // Mark as safe

        dfs(board, i - 1, j)
        dfs(board, i + 1, j)
        dfs(board, i, j - 1)
        dfs(board, i, j + 1)
    }
}