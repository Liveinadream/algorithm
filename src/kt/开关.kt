package kt

import java.util.*

object Start {
    @JvmStatic
    fun main(args: Array<String>) {
        var i = baseArray()

        bubbleSort(i)
        print("\n冒泡排序结果:${Arrays.toString(i)}\n")

        i = baseArray()
        selectionSort(i, i.size)
        print("\n选择排序结果:${Arrays.toString(i)}\n")
    }

    private fun baseArray(): IntArray {
        return listOf(4, 2, 2, 23, 3).toIntArray()
    }
}
