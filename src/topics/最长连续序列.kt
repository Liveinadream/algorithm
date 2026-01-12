package topics

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,0,1,2]
 * 输出：3
 * 解：
 * 先去重,然后判断前向数字是否存在，不存在则数明该数字可以为起点
 * 继续向后判断是否存在数字，记录最大长度
 */

object SolutionB {
    @JvmStatic
    fun main(args: Array<String>){
        val numArray = intArrayOf(100,4,200,1,3,2)
        val set = HashSet<Int>()
        numArray.forEach {
            arg ->
            set.add(arg)
        }
        var maxArray = 1;
        for( i in set){
            //判断前向是否存在数字
            if(!set.contains(i-1)){
                var currentNum = i
                var currentStreak = 1
                //判断该数字后面还有数，那么长度加1
                while (set.contains(currentNum+1)){
                    currentStreak++
                    currentNum++
                }
                //记录最大的数
                maxArray = maxOf(currentStreak,maxArray)
            }
        }
//        return maxArray
    }
}