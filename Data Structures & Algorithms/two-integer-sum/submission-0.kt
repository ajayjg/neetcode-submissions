class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for(i in 0 until nums.size) {
            val comp = target - nums[i]
            if(map.containsKey(comp)) {
                return intArrayOf(map[comp]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf(0,0)
    }
}
