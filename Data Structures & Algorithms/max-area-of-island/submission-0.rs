impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        let mut grid = grid;

        let rows = grid.len();
        let cols = grid[0].len();

        let mut max_area = 0;

        for r in 0..rows {
            for c in 0..cols {

                if grid[r][c] == 1 {

                    let area = Self::dfs(
                        &mut grid,
                        r as i32,
                        c as i32
                    );

                    max_area = max_area.max(area);
                }
            }
        }

        max_area
    }

    fn dfs(
        grid: &mut Vec<Vec<i32>>,
        r: i32,
        c: i32
    ) -> i32 {

        let rows = grid.len() as i32;
        let cols = grid[0].len() as i32;

        // boundary + water check
        if r < 0 ||
            c < 0 ||
            r >= rows ||
            c >= cols ||
            grid[r as usize][c as usize] == 0
        {
            return 0;
        }

        // mark visited
        grid[r as usize][c as usize] = 0;

        let mut area = 1;

        area += Self::dfs(grid, r + 1, c);
        area += Self::dfs(grid, r - 1, c);
        area += Self::dfs(grid, r, c + 1);
        area += Self::dfs(grid, r, c - 1);

        area
    }
}