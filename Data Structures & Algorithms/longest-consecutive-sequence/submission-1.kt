class Solution {
    fun longestConsecutive(nums: IntArray): Int {

        val set = nums.toHashSet()

        var longest = 0

        for (num in set) {

            // Start of sequence
            if (!set.contains(num - 1)) {

                var current = num
                var streak = 1

                while (set.contains(current + 1)) {
                    current++
                    streak++
                }

                longest = maxOf(longest, streak)
            }
        }

        return longest
    }
}