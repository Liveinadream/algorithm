package topics

import examination.ListNode

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 解：需要注意的是，交换后，上一个节点的下一个指向值会变更，指向当前的组的前节点
 */
class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val returnNode = head?.next ?: head
        var tail = head
        //定义一个前向值 last
        var last: ListNode? = null
        while (tail != null) {
            val next = tail.next ?: break
            val temp = tail.next?.next
            tail.next = temp
            next.next = tail
            tail = temp
            if (last != null) {
                last.next = next
                last = next.next
            } else {
                last = head
            }
        }
        return returnNode
    }
}