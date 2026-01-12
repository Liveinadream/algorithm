package topics

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
object MaxWater {
    @JvmStatic
    fun main(strArray: Array<String>){
        val numArray = intArrayOf(100,4,200,1,3,2)
        var left = 0
        var right = numArray.size-1
        var max =0
        //自己想到的，直接双重循环，数量多了后超时
//        for (left in 0 until numArray.size-1) {
//            for(right in left+1  until numArray.size){
//                max = maxOf(max,minOf(numArray[left],numArray[right])*(right-left))
//            }
//        }
        //双指针，从两头开始计算，将短的一方进行移动
        while (left !=right){
            max = maxOf(max,minOf(numArray[left],numArray[right])*(right-left))
            if(numArray[left]<numArray[right]){
                left++
            }else{
                right--
            }
        }

    }
}