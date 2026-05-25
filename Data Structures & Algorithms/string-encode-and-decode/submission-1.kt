class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()

        for (str in strs) {
            sb.append(str.length)
                .append('#')
                .append(str)
        }

        return sb.toString()
    }

    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < s.length) {

            var j = i

            while (s[j] != '#') {
                j++
            }

            val length = s.substring(i, j).toInt()

            val word = s.substring(j + 1, j + 1 + length)

            result.add(word)

            i = j + 1 + length
        }

        return result
    }

}
