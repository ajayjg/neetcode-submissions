class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1

        var maxArea = 0

        while(left < right) {
            val width = right - left
            val height = minOf(heights[left], heights[right])

            val area = width * height

            maxArea = maxOf(area, maxArea)

            if(heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }
}
