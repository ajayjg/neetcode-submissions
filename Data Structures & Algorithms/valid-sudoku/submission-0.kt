class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val boxes = Array(9) { HashSet<Char>() }

        for (r in 0 until 9) {
            for (c in 0 until 9) {

                val value = board[r][c]

                if (value == '.') continue

                val boxIndex = (r / 3) * 3 + (c / 3)

                // Duplicate found
                if (
                    value in rows[r] ||
                    value in cols[c] ||
                    value in boxes[boxIndex]
                ) {
                    return false
                }

                rows[r].add(value)
                cols[c].add(value)
                boxes[boxIndex].add(value)
            }
        }

        return true
    }
}