package topics

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 要求空间复杂度为哦 o1
 *
 * 解：部分反转
 * nums = "----->-->"; k =3
 * result = "-->----->";
 *
 * reverse "----->-->" we can get "<--<-----"
 * reverse "<--" we can get "--><-----"
 * reverse "<-----" we can get "-->----->"
 * this visualization help me figure it out :)
 */
class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        //自己的想法，新数组记录并交换,空间上超出使用
        var nextIndex: Int = k % nums.size
        val numsSize = nums.size
        val newInArray = IntArray(numsSize) { 0 }
        for (i in nums.indices) {
            if (i + nextIndex >= numsSize) {
                newInArray[i + nextIndex - numsSize] = nums[i]
            } else {
                newInArray[i + nextIndex] = nums[i]
            }
        }
        for (i in nums.indices) {
            nums[i] = newInArray[i]
        }
        //反转方法
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, nextIndex - 1)
        reverse(nums, nextIndex, nums.size - 1)

    }

    fun reverse(nums: IntArray, start: Int, end: Int) {
        var start = start
        var end = end
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1
        }
    }
}