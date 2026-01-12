package topics

import java.util.*

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 解：先以左值从小到大排序
 * 因为右侧值总比该index 左值要大，所有记录最大右侧值与下一个 index 左值进行比较，比较完后进行添加或继续比较
 */
class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }
        Arrays.sort(intervals, Comparator { interval1, interval2 -> interval1[0] - interval2[0] })
        val returnList = mutableListOf<IntArray>()
        var left = 0
        var right = 1
        var max = intervals[left][1]
        while (right < intervals.size) {
            if (right == intervals.size - 1) {
                if (max >= intervals[right][0]) {
                    returnList.add(intArrayOf(intervals[left][0], maxOf(max, intervals[right][1])))
                } else {
                    returnList.add(intArrayOf(intervals[left][0], max))
                    returnList.add(intArrayOf(intervals[right][0], intervals[right][1]))
                }
                break
            } else {
                if (max < intervals[right][0]) {
                    returnList.add(intArrayOf(intervals[left][0], max))
                    left = right
                }
                max = maxOf(max, intervals[right][1])
                right++
            }
        }

        //最快解,先记录后比较左，进行右侧重记录或者添加该index
        Arrays.sort(intervals, Comparator { p, q -> p!![0] - q!![0] })

        val arr = ArrayList<IntArray>()

        for (inter in intervals) {
            val size = arr.size

            if (size > 0 && inter[0] <= arr[size - 1][1]) {
                arr[size - 1][1] = maxOf(arr[size - 1][1], inter[1])
            } else {
                arr.add(inter)
            }
        }
        return arr.toTypedArray()
    }
}