/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 解:双指针解法
 * 1. 定义一个指针 zeroIndex 记录0的索引位置
 * 2. 遍历数组，将非0元素移动到数组前面，记录0的索引位置
 * 3. 遍历数组，将0元素移动到数组后面
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution0 {
    fun moveZeroes(nums: IntArray) {
        var zeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i]
                zeroIndex++
            }
        }
        for (i in zeroIndex until nums.size) {
            nums[i] = 0
        }
    }

    fun moveZeroes1(nums: IntArray) {
        var l = 0
        for (r in nums.indices) {
            if (nums[r] != 0) {
                var temp = nums[l]
                nums[l] = nums[r]
                nums[r] = temp
                l++
            }
        }
    }
}