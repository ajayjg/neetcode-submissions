impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        let mut grid = grid;
        
        let rows = grid.len();
        if rows == 0 {
            return 0;
        }

        let cols = grid[0].len();
        let mut islands = 0;

        for r in 0..rows {
            for c in 0..cols {

                if grid[r][c] == '1' {
                    islands += 1;
                    Self::dfs(&mut grid, r as i32, c as i32);
                }
            }
        }

        islands
    }

    fn dfs(grid: &mut Vec<Vec<char>>, r: i32, c: i32) {
        let rows = grid.len() as i32;
        let cols = grid[0].len() as i32;

        // boundary + water check
        if r < 0 || c < 0 || r >= rows || c >= cols ||
            grid[r as usize][c as usize] == '0' {
            return;
        }

        // mark visited
        grid[r as usize][c as usize] = '0';

        // 4 directions
        Self::dfs(grid, r + 1, c);
        Self::dfs(grid, r - 1, c);
        Self::dfs(grid, r, c + 1);
        Self::dfs(grid, r, c - 1);
    }
}