package topics

import java.util.*

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * p 字符可重复
 * 根据题目要求，我们需要在字符串 s 寻找字符串 p 的异位词。
 * 因为字符串 p 的异位词的长度一定与字符串 p 的长度相同，
 * 所以我们可以在字符串 s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，
 * 并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，
 * 则说明当前窗口为字符串 p 的异位词。
 *
 */
class Solution438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val list = mutableListOf<Int>()
        if (p.length > s.length) {
            return list
        }
//        var right = 0
        //记录 p 的Set,时间过长
//        val pSet = mutableListOf<Char>()
//        for (i in 0 until p.length) {
//            pSet.add(p[i])
//        }
//        var tempPSet = pSet.toMutableList()
//        while (right <= s.length - p.length) {
//            for (i in 0 until pSet.size) {
//                val sCurrent = i + right
//                //p中没有这个i
//                if (!tempPSet.contains(s[sCurrent])) {
//                    tempPSet = pSet.toMutableList()
//                    if (pSet.contains(s[sCurrent])) {
//                        right++
//                    } else {
//                        right += i + 1
//                    }
//                    break
//                }
//                tempPSet.remove(s[i + right])
//                if (tempPSet.isEmpty()) {
//                    list.add(right)
//                    right++
//                    tempPSet = pSet.toMutableList()
//                }
//            }
//        }
        //申明两个数组，比较数组中记录的值
//        val sCount = IntArray(26)
//        val pCount = IntArray(26)
//        for (i in 0 until p.length) {
//            ++sCount[s[i] - 'a']
//            ++pCount[p[i] - 'a']
//        }
//        if (sCount.contentEquals(pCount)) {
//            list.add(0)
//        }
//        for (i in 0 until s.length - p.length) {
//            --sCount[s[i] - 'a']
//            ++sCount[s[i + p.length] - 'a']
//
//            if (sCount.contentEquals(pCount)) {
//                list.add(i + 1)
//            }
//        }
        //最快解
        // 两个循环，分别控制r和l
        var l = 0
        list.clear()
        val pCount = IntArray(26)
        for (i in 0 until p.length) {
            ++pCount[p[i] - 'a']
        }
        for (r in 0 until s.length) {
            val charIndex = s[r] - 'a'
            pCount[charIndex]--
            // 当滑动窗口长度达到p.length时
            // 如果不匹配，在这及之前一定会有负数出现
            // 如果有负数，那么需要移动窗口
            // 使l移动到现在负数的位置之后
            // 即 pCount 中的没有的值为-1，一直向左滑动直到窗口中不存在-1
            while (pCount[charIndex] < 0) {
                pCount[s[l] - 'a']++
                l++
            }
            if (r - l + 1 == p.length) {
                list.add(l)
            }
        }
        return list
    }
}