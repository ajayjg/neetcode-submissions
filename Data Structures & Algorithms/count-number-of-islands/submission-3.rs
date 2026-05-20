use std::collections::VecDeque;

impl Solution {
    //BFS Solv
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

                    let mut queue = VecDeque::new();
                    queue.push_back((r, c));

                    // mark visited immediately
                    grid[r][c] = '0';

                    while let Some((row, col)) = queue.pop_front() {

                        let directions = [
                            (1, 0),
                            (-1, 0),
                            (0, 1),
                            (0, -1),
                        ];

                        for (dr, dc) in directions {

                            let nr = row as i32 + dr;
                            let nc = col as i32 + dc;

                            if nr >= 0 &&
                                nc >= 0 &&
                                nr < rows as i32 &&
                                nc < cols as i32 {

                                let nr_u = nr as usize;
                                let nc_u = nc as usize;

                                if grid[nr_u][nc_u] == '1' {

                                    grid[nr_u][nc_u] = '0';

                                    queue.push_back((nr_u, nc_u));
                                }
                            }
                        }
                    }
                }
            }
        }

        islands
    }
}