package topics

/**
 * 给你一个整数数组 testArray ，判断是否存在三元组 [testArray[i], testArray[j], testArray[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 testArray[i] + testArray[j] + testArray[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组,下标不同即可
 */
object ThreeNumSum {

    @JvmStatic
    fun threeSum(testArray: IntArray): List<List<Int>> {
        val intList = mutableListOf<List<Int>>()
        //排序，
        testArray.sort()
        for (i in 0 until testArray.size - 2) {
            //不是第一个数，但是与前一个数相同，跳过
            if (i > 0 && testArray[i] == testArray[i - 1]) {
                continue
            }

            println("开始计算和 target = ${-testArray[i]}")
            sumNum(
                testArray, i + 1, testArray.size - 1, -testArray[i],
                testArray[i], intList
            )
        }
        println("最终结果：${intList.size}")
        return intList
    }

    fun sumNum(
        testArray: IntArray,
        right: Int,
        left: Int,
        target: Int,
        currentValue: Int,
        intList: MutableList<List<Int>>
    ) {
        var rightTemp = right
        var leftTemp = left
        while (rightTemp < leftTemp) {
            val sum = testArray[rightTemp] + testArray[leftTemp]
            if (sum == target) {
                val list = mutableListOf<Int>()
                list.add(testArray[rightTemp])
                list.add(testArray[leftTemp])
                list.add(currentValue)
                intList.add(list)
                //右指针与下一个数相同，说明，元素重复，不可再使用
                while (rightTemp < leftTemp && testArray[rightTemp] == testArray[rightTemp + 1]) {
                    rightTemp++
                }
                rightTemp++
                //如上
                while (rightTemp < leftTemp && testArray[leftTemp] == testArray[leftTemp - 1]) {
                    leftTemp--
                }
                leftTemp--
            } else if (sum < target) {
                rightTemp++
            } else {
                leftTemp--
            }
        }
    }
}