package topics

import java.util.Arrays


/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 *
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 解释：
 *
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 *
 * 解：
 * 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串
 * 分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
 */
object Test {
    @JvmStatic
    fun main(args: Array<String>){
        val strArray: Array<String> = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        val map = HashMap<String, MutableList<String>>()
        for (str in strArray) {
            val array = str.toCharArray()
            Arrays.sort(array)
            val key = String(array)
            val list = map.getOrDefault(key, ArrayList())
            list.add(str)
            map[key] = list
        }
//        return ArrayList<List<String>>(map.values)
    }


}


