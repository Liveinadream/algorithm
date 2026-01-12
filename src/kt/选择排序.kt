package kt

/**
 *  在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
 *  第二次遍历n-2个数，找到最小的数值与第二个元素交换；
 *  。。。
 *  第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
 *
 *  时间复杂度：O(n2)
 */
fun selectionSort(array: IntArray, length: Int) {
    for (i in 0 until length) {
        var minIndex = i
        for (j in i + 1 until length) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }
    }
}