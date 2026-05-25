class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        // Frequency map
        val freqMap = HashMap<Int, Int>()

        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        // Bucket array
        val bucket = Array(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in freqMap) {
            bucket[freq].add(num)
        }

        val result = mutableListOf<Int>()

        // Traverse from highest frequency
        for (i in bucket.indices.reversed()) {
            for (num in bucket[i]) {
                result.add(num)

                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return result.toIntArray()
    }
}