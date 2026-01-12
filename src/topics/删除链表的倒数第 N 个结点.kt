package topics

import examination.ListNode

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 */
class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        //方法1 计算长度，然后删除对应的节点
        val dummy = ListNode(0)
        dummy.next = head
        var tail = head
        var length = 0
        //长度计算
        while (tail != null) {
            length++
            tail = tail.next
        }
        tail = dummy
        //删除对应节点
        for (i in 1 until length - n + 1) {
            tail = tail?.next
        }
        tail?.next = tail.next?.next

        //方法2 定义first 和 second ,当second 前进到 n 时，
        // 开始同时前进 first,second 前进到末位时，first 的下一位就是需要删除的节点
        var first = head
        var second: ListNode? = dummy
        for (i in 0 until n) {
            first = first!!.next
        }
        while (first != null) {
            first = first.next
            second = second?.next
        }
        second!!.next = second.next!!.next
        return dummy.next
    }
}