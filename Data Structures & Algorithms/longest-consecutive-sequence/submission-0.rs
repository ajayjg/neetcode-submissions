use std::collections::HashSet;

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }

        let num_set: HashSet<i32> = nums.into_iter().collect();
        let mut max_length = 0;

        for &num in &num_set {
            // Start a new sequence only if the previous number doesn't exist
            if !num_set.contains(&(num - 1)) {
                let mut current = num;
                let mut current_length = 1;

                // Extend the sequence forward
                while num_set.contains(&(current + 1)) {
                    current += 1;
                    current_length += 1;
                }

                max_length = max_length.max(current_length);
            }
        }

        max_length
    }
}