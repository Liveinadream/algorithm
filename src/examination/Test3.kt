package examination

import topics.*

/**
 * [4,1,2,1,2]
 */
object Test3 {
    @JvmStatic
    fun main(args: Array<String>) {
//        val test = Solution23()
//        val intervals = mutableListOf<IntArray>()
//        intervals.add(intArrayOf(1, 3))
//        intervals.add(intArrayOf(2, 6))
//        intervals.add(intArrayOf(8, 10))
//        intervals.add(intArrayOf(15, 18))
//        val intArray = intArrayOf(1,2,3,4)
//        println(test.firstMissingPositive(intArray))
//        val node4 = ListNode(4)
//        val node3 = ListNode(3, node4)
//        val node2 = ListNode(2, node3)
//        val node1 = ListNode(1, node2)
//        println(node1.toString())
//        println(node2.toString())
//        println(node3.toString())
//        println(node4.toString())

//        val node42 = ListNode(8)
//        val node32 = ListNode(7, node42)
//        val node22 = ListNode(6, node32)
//        val node12 = ListNode(5, node22)
//        val array = Array<ListNode?>(2) { ListNode(0) }
//        array[0] = node1
//        array[1] = node12

//        val nums = IntArray(5){-1}
//        nums[0] = 4
//        nums[1] = 1
//        nums[2] = 2
//        nums[3] = 1
//        nums[4] = 2
//        test.mergeKLists(array)
        val lruCache = LRUCache(2)
        var getValue = -1
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        getValue = lruCache.get(1)
        lruCache.put(3, 3)
        getValue = lruCache.get(2)
        lruCache.put(4, 4)
        getValue = lruCache.get(1)
        getValue = lruCache.get(3)
        getValue = lruCache.get(4)

    }
}