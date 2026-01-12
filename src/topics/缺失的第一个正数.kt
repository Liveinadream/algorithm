package topics

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 解：记录当前值对应的Index ，存在则添加负号保持为一个负数
 */
class Solution41 {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        //过滤负数
        for (i in nums.indices) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //使对应下标的index 变为负数
        for (i in nums.indices) {
            if (nums[i] > nums.lastIndex) {
                continue
            }
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[i])
        }
        //找出第一个不为负数的值
        for (i in nums.indices) {
            if (nums[i] > 0) {
                return i + 1
            }
        }

        return n + 1
    }
}