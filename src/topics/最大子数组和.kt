package topics

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 * 方法一：动态规划
 * 思路和算法
 *
 * 假设 nums 数组的长度是 n，下标从 0 到 n−1。
 *
 * 我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
 * max0≤i≤n−1{f(i)}
 *
 * 因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。
 * 那么我们如何求 f(i) 呢？我们可以考虑 nums[i] 单独成为一段还是加入 f(i−1) 对应的那一段，
 * 这取决于 nums[i] 和 f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
 *
 * f(i)=max{f(i−1)+nums[i],nums[i]}
 *
 * 不难给出一个时间复杂度 O(n)、空间复杂度 O(n) 的实现，即用一个 f 数组来保存 f(i) 的值，
 * 用一个循环求出所有 f(i)。考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量
 * pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
 */
class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        var maxNum = nums[0]
        var pre = 0
        for (i in nums) {
            pre = maxOf(i, pre + i)
            maxNum = maxOf(maxNum, pre)
        }
        return maxNum
    }

    /**
     * 分治
     */
    fun maxSubArray2(nums: IntArray): Int {
        val ans = action(nums, 0, nums.size)
        return ans[2]
    }

    fun action(nums: IntArray, start: Int, end: Int): IntArray {
        if (end-start == 1) return intArrayOf(nums[start],nums[start],nums[start],nums[start])
        val mid = (start+end) shr 1

        val left = action(nums, start, mid)
        val right = action(nums, mid, end)

        val lSum = maxOf(left[0], left[3]+right[0])
        val rSum = maxOf(right[1], right[3]+left[1])
        val mSum = maxOf(maxOf(left[2], right[2]), left[1]+right[0])
        val iSum = left[3] + right[3]

        return intArrayOf(lSum, rSum, mSum, iSum)
    }
}