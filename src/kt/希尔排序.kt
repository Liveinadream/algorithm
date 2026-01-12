package kt

/**
 * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序
 * 然后逐渐将增量减小重复上述过程，直至增量为1，此时数据序列基本有序,最后进行插入排序
 * 时间复杂度：O(n1.5)
 */
fun shellSort(array: IntArray, length: Int) {

    var temp = 0
    var incre = length

    while (true) {
        incre /= 2

        for (k in 0 until incre) {

            var i = k + incre
            while (i < length) {

                var j = i
                while (j > k) {
                    if (array[j] < array[j - incre]) {
                        temp = array[j - incre]
                        array[j - incre] = array[j]
                        array[j] = temp
                    } else {
                        break
                    }
                    j -= incre
                }
                i += incre
            }
        }

        if (incre == 1) break
    }
}