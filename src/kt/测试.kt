package kt

/**
 * 测试自己直接写的能力
 */
fun test1(array: IntArray) {

    //测试快速排序能力，key值取中间数

    quickSort(array, array[array.size / 2], array.size - 1)


}

fun quickSort1(array: IntArray, left: Int, right: Int) {

    //首先判断left>right的值,代表该数组是否排序完毕

    if (left > right) return

    var i = left
    var j = right
    val key = array[left] //选择左边开始的数作为key值，挖坑开始位置

    //循环发生在，左位置小于右位置的范围内

    while (i < j) {

        //从右向左找第一个小于key的值
        while (i < j && array[j] >= key) {
            //向左移动一个位置
            j--
        }
        if (i < j) {
            //填key值的坑
            array[i] = array[j]
            i++
        }

        //从左向右找第一个大于key的值
        while (i < j && array[i] < key) {
            i++
        }

        if (i < j) {
            //填给予key值的位置的坑
            array[j] = array[i]
            j--
        }
    }
    //找出近乎与中直的点
    array[i] = key
    quickSort1(array, left, i - 1)
    quickSort1(array, i + 1, right)


}