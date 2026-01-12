package topics

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 *
 */
class Solution136 {
    fun singleNumber(nums: IntArray): Int {
        //自己想到的，不考虑空间,时间复杂度 O2n 即 On,空间复杂度，On
//        val map = HashMap<Int, Int?>()
//        for (i in nums.indices) {
//            if (map.containsKey(nums[i])) {
//                map[nums[i]] = map[nums[i]]!! + 1
//            } else {
//                map[nums[i]] = 1
//            }
//        }
//
//        for (entry in map) {
//            if (entry.value == 1) {
//                return entry.key
//            }
//        }
        //自己想到的，先排序，在依次比较
        nums.sort()
        var stepTemp = 1
        var i = 0
        while (i < nums.size) {
            stepTemp = 1
            if (i < nums.lastIndex) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i]
                }
            } else {
                return nums[i]
            }
            //当前数字等于下一个数字时，令stepTemp 加 1，直到不相等
            while (nums[i] == nums[i + stepTemp]) {
                ++stepTemp
            }
            i += stepTemp
        }
        //题解： 异或运算,因为要不一次要不两次，两次异或自己必为0
        var single = 0
        for (num in nums) {
            single = single xor num
        }
        return single


        return -1
    }
}