package topics

import examination.ListNode
import java.util.PriorityQueue
import java.util.Stack

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        //自己的想法：定义一个优先队列栈，放入全部的list 头，总是取出最小的并放入下一个取出的下一个元素
        val dummy = ListNode(0, null)
        var tail: ListNode? = dummy
        val queue = PriorityQueue<ListNode>(compareBy { it.value })
        //存入队头
        for (i in lists.indices) {
            if (lists[i] != null) {
                queue.offer(lists[i])
            }
        }
        //重新组合
        while (queue.peek() != null) {
            val node = queue.poll()
            tail?.next = node
            val next = node.next
            if (next != null) {
                queue.add(node.next)
            }
            tail = node
        }
        //最快方法，分治法,两两合并，
        return mergeRange(lists, 0, lists.size - 1)
//        return dummy.next
    }

    fun mergeRange(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
        if (left > right) {
            return null
        }
        if (left == right) {
            return lists[left]
        }

        val mid = left + (right - left) / 2
        return mergeTwoNodeList(mergeRange(lists, left, mid), mergeRange(lists, mid + 1, right))
    }

    fun mergeTwoNodeList(node1: ListNode?, node2: ListNode?): ListNode? {
        if (node1 == null || node2 == null) {
            return node1 ?: node2
        }
        val dummyNode = ListNode(0)
        var tail: ListNode? = dummyNode

        var start1 = node1
        var start2 = node2
        while (start1 != null && start2 != null) {
            if (start1.value <= start2.value) {
                tail?.next = start1
                start1 = start1.next
            } else {
                tail?.next = start2
                start2 = start2.next
            }
            tail = tail?.next
        }

        tail?.next = start1 ?: start2

        return dummyNode.next
    }
}