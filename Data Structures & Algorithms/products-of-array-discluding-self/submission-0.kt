class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val result = IntArray(nums.size)

        // Prefix
        var prefix = 1

        for (i in nums.indices) {
            result[i] = prefix
            prefix *= nums[i]
        }

        // Postfix
        var postfix = 1

        for (i in nums.indices.reversed()) {
            result[i] *= postfix
            postfix *= nums[i]
        }

        return result
    }
}