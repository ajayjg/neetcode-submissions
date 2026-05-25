class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for(str in strs) {
            val sorted = str.toCharArray().sorted().joinToString("")

            map.getOrPut(sorted) { mutableListOf()}.add(str)
        }

        return map.values.toList()
    }
}
