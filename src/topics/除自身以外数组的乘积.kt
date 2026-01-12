package topics

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        //使用除法
//        var total = 1
//        var zeroNum = 0
//        for (num in nums) {
//            if (num == 0) {
//                zeroNum++
//            } else {
//                total *= num
//            }
//        }
//        for (i in nums.indices) {
//            if (nums[i] == 0) {
//                if (zeroNum == 1) {
//                    nums[i] = total
//                } else {
//                    nums[i] = 0
//                }
//            } else {
//                if (zeroNum > 0) {
//                    nums[i] = 0
//                } else {
//                    nums[i] = total / (nums[i])
//                }
//            }
//        }
        //不使用除法，先获得前向积
        val useArray = IntArray(nums.size) { 1 }
        //总是代表当前的元素后向积,最后一个数默认后向积为1
        var r = 1
        //获得前向积
        for (i in nums.indices) {
            if (i == 0) {
                useArray[0] = 1
                continue
            }
            useArray[i] = useArray[i - 1] * nums[i - 1]
        }
        for (i in nums.lastIndex downTo 0) {
            if (i == 0) {
                useArray[0] = r
                continue
            }
            useArray[i] = useArray[i] * r
            r *= nums[i]
        }
        return useArray
    }
}