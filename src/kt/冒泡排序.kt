package kt

/**
 * 两个数比较大小，较大的数下沉，较小的数冒起来
 * 时间复杂度 O(n2)
 * 优点：稳定排序，适用于数组存储的数据和链表存储的数据
 */
fun bubbleSort(arr: IntArray) {

    var temp: Int
    var flag: Boolean

    for (i in 0 until arr.size - 1) {
        flag = false
        for (j in arr.size - 1 downTo i + 1) {

            if (arr[j] < arr[j - 1]) {
                temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
                flag = true
            }
        }
        //如果扫描一边没有发生交换，则说明序列已经有序，退出循环
        if (!flag) break

    }

}

