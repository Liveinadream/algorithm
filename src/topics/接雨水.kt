package topics

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 解：双指针法
 * 注意到下标 i 处能接的雨水量由 leftMax[i] 和 rightMax[i] 中的最小值决定。
 * 由于数组 leftMax 是从左往右计算，数组 rightMax 是从右往左计算，因此可以使用双指针和两个变量代替两个数组。
 *
 * 维护两个指针 left 和 right，以及两个变量 leftMax 和 rightMax，
 * 初始时 left=0,right=n−1,leftMax=0,rightMax=0。指针 left 只会向右移动，
 * 指针 right 只会向左移动，在移动指针的过程中维护两个变量 leftMax 和 rightMax 的值。
 *
 * 当两个指针没有相遇时，进行如下操作：
 *
 * 使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax 的值；
 *
 * 如果 height[left]<height[right]，则必有 leftMax<rightMax，
 * 下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；
 *
 * 如果 height[left]≥height[right]，则必有 leftMax≥rightMax，
 * 下标 right 处能接的雨水量等于 rightMax−height[right]，将下标 right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。
 *
 * 当两个指针相遇时，即可得到能接的雨水总量。
 *
 * 个人理解：
 * 使用低的柱子与高柱子进行积水累加，知道最后左右指针相同后跳出循环
 */
class Solution {

    fun trap(height: IntArray): Int {
        var ans = 0
        var left = 0
        var right = height.size - 1
        var leftMax = 0
        var rightMax = 0
        while (left < right) {
            leftMax = maxOf(leftMax, height[left])
            rightMax = maxOf(rightMax, height[right])
            if (height[left] < height[right]) {
                ans += leftMax - height[left]
                ++left
            } else {
                ans += rightMax - height[right]
                --right
            }
        }
        return ans
    }
}