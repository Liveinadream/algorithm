package topics

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 解使用滑动窗口，记录左右点判断下一个字符是否在当前子串内
 */
class SolutionA {
    fun lengthOfLongestSubstring(str: String): Int {
        var maxLength = minOf(1, str.length)
        var right = 0
        var left = 1
        //个人解，subString 时间较长
//        while (s.length > 1) {
//            val currentString = s.substring(right, left)
//            if (currentString.contains(s[left])) {
//                val nextStart = currentString.indexOf(s[left]) + 1
//                if (nextStart >= s.length) {
//                    break
//                }
//                right += nextStart
//                left = right + 1
//                if (left >= s.length) {
//                    break
//                }
//                continue
//            }
//            maxLength = maxOf(currentString.length + 1, maxLength)
//            //当前最大长度大于剩余字符串长度
//            if (maxLength > s.length - right) {
//                break
//            }
//            left++
//            if (left >= s.length) {
//                break
//            }
//        }
        //实际解，用hashSet 记录新字符
        val chars = hashSetOf<Char>()
        str.forEachIndexed { index, _ ->
            // 当索引大于0的时候，执行以下逻辑
            if (index > 0) {
                // 移除一个字符，左指针向右移动一格
                chars.remove(str[index - 1])
            }
            while (right < str.length && !chars.contains(str[right])) {
                // 如果索引小于字符串的长度，同时该字符没出现过，就将该字符放到哈希集合中，然后右指针向右移动一格
                chars.add(str[right])
                right++
            }
            // 计算长度的最大值
            maxLength = maxOf(maxLength, right - index)
        }

        //最快解
        // 使用一个固定大小的 IntArray 来代替 HashMap
        // 大小为 128，覆盖标准 ASCII 字符集
        // 初始化为 -1，表示该字符尚未出现过
        right = 0
        left = 0
        val lastSeenIndex = IntArray(128) { -1 }
        // 使用传统的 for 循环，有时比 forEachIndexed 有微弱的优势
        for (right in str.indices) {
            val currentChar = str[right]
            val charCode = currentChar.toInt() // 将 Char 转换为 Int 码点

            // 检查该字符是否在当前窗口内出现过
            // lastSeenIndex[charCode] 存储的是该字符上一次出现的位置
            val prevIndex = lastSeenIndex[charCode]
            if (prevIndex >= left) {
                // 如果出现过，并且位置在窗口内，则移动左边界
                left = prevIndex + 1
            }

            // 更新该字符的最新出现位置
            lastSeenIndex[charCode] = right

            // 计算并更新最大长度
            maxLength = maxOf(maxLength, right - left + 1)
        }
        return maxLength
    }
}