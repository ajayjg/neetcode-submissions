class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        return s.toCharArray().sorted().joinToString("").equals(t.toCharArray().sorted().joinToString(""))
    }
}
