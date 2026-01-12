package topics

import examination.ListNode

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 1 -> 2 -> 3 -> 4
 * 拿到1 2进行交换,2 指向 1，下一个是3
 * 1 <- 2 3 -> 4
 * 拿到2 3 进行交换，3 指向 2 ，下一个是4
 * 1 <- 2 <- 3  4
 * 拿到3 4 进行指向交换 ，下一个指向 null
 * 1 <- 2 <- 3 <- 4
 *
 * 反转状态中，链表是断成两截的
 */
class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        var next = head?.next
        var last = head
        head?.next = null
        while (next != null) {
            val temp = next.next
            next.next = last
            last = next
            next = temp
        }

        return last
    }
}