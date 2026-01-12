package kt

/**
 * 在要排序的一组数中，假定前n-1个数已经排好序，
 * 现在将第n个数插到前面的有序数列中，
 * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 时间复杂度：O(n2)
 */

fun InsertionSort(array: IntArray) {
    var temp = 0
    for (i in 0 until array.size - 1) {
        for (j in i + 1 downTo 1) {
            if (array[j] < array[j - 1]) {
                temp = array[j - 1]
                array[j - 1] = array[j]
                array[j] = temp
            } else {
                break
            }
        }
    }
}
