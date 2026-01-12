package topics

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * 解：计算出前缀和，利用前缀和进行比较
 * 解2:
 * 累加和加上哈希
 * 可以用累加和与哈希，一起可以优化到O（n）。
 *
 * 思路是这样的，记Si=sum[0, i]，其中i=[0, n-1]，那么子数组S[j-1, k]的和可用Sk - Sj来计算。假如某个子数组的和为k，那么必然会存在一个子数组，Si=k+Sj，这个子数组便是[j-1, i]。
 *
 * 把从0，到n-1的Si先放入一个哈希表中，键为Si，值是其出现的个数。然后再尝试寻找Si-k的个数 就可以了，这个个数就是[0, i]中和为k的子数组的个数。
 */
class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            var sum = 0
            for (end in start downTo 0) {
                sum += nums[end]
                if (sum == k) {
                    count++
                }
            }
        }
        //解2 hash ，类似于两数和
        var result = 0
        var sum = 0
        val sumTable = HashMap<Int?, Int?>()
        sumTable[0] = 1
        for (i in nums.indices) {
            sum += nums[i]
            result += sumTable.getOrDefault(sum - k, 0)!!
            sumTable[sum] = sumTable.getOrDefault(sum, 0)!! + 1
        }

        return count
    }
}