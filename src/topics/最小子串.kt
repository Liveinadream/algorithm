package topics

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 解：记录 t 中字符数量，记录滑动窗口左右移动是否有 t 中元素
 */
class Solution76 {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) {
            return ""
        }
        val sCharArray = s.toCharArray()
        val tCharArray = t.toCharArray()
        val useArray = IntArray(128) { 0 }
        val tempArray = IntArray(128) { 0 }
        for (i in tCharArray.indices) {
            useArray[tCharArray[i].toInt()]++
            tempArray[tCharArray[i].toInt()]++
        }
        var right = 0
        //记录出最小子串
        var minLength = Int.MAX_VALUE
        val minEntry = intArrayOf(0, 0)
        var currentCharArraySize = t.length
        for (i in sCharArray.indices) {
            val charNum = useArray[sCharArray[i].toInt()]
            if (charNum == 0) {
                continue
            }
            tempArray[sCharArray[i].toInt()] -= 1
            if (tempArray[sCharArray[i].toInt()] >= 0) {
                currentCharArraySize--
            }
            //当前串数量不为0时，代表子串还不可用
            if (currentCharArraySize != 0) {
                continue
            }
            while ((useArray[sCharArray[right].toInt()] == 0 || tempArray[sCharArray[right].toInt()] < 0)
                && right < i
            ) {
                if (useArray[sCharArray[right].toInt()] != 0) {
                    tempArray[sCharArray[right].toInt()] += 1
                }
                right++
            }
            val length = i - right + 1
            tempArray[sCharArray[right].toInt()] += 1
            //准备开始新的一个子串判断，判断当前子串距离,
            if (length >= minLength) {
                right++
                currentCharArraySize++
                continue
            }
            //符合则记录
            minLength = length
            minEntry[0] = right
            minEntry[1] = i
            currentCharArraySize++
            right++
        }
        if (minLength == Int.MAX_VALUE) {
            return ""
        }
        return s.substring(minEntry[0], minEntry[1] + 1)
    }
}