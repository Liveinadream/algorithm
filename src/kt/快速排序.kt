package kt

/**
 * 先从数列中取出一个数值为key的值
 * 将比这个数小的数全部放在左边，大于或等于它的数全部放在他的右边
 * 对左右两个小数列重复第二步，直至各个区间的只有一个数
 * 时间复杂度:O(N*logN)
 */
fun quickSort(arr: IntArray, l: Int, r: Int) {

    if (l > r) return
    var i = l
    var j = r
    val key = arr[l] //选择第一个数作为key

    while (i < j) {
        //从右到左找到第一个小于key的值
        while (i < j && arr[j] >= key) {
            j--
        }

        if (i < j) {
            arr[i] = arr[j]
            i++
        }
        //从左到右找到第一个大于等于key的值
        while (i < j && arr[i] < key) {
            i++
        }

        if (i < j) {
            arr[j] = arr[i]
            j--
        }
    }

    arr[i] = key
    quickSort(arr, l, i - 1)
    quickSort(arr, i + 1, r)

}