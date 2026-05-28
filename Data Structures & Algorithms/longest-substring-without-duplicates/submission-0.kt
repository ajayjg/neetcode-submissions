class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        
        val lastIndex = IntArray(128) { -1 } // Supports ASCII characters
        var left = 0
        var maxLength = 0
        
        for (right in s.indices) {
            val char = s[right]
            
            // If character appears in current window
            if (lastIndex[char.code] >= left) {
                left = lastIndex[char.code] + 1
            }
            
            lastIndex[char.code] = right
            maxLength = maxOf(maxLength, right - left + 1)
        }
        
        return maxLength
    }
}