package topics

import examination.ListNode
import examination.Node

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 */
class Solution138 {
    fun copyRandomList(node: ListNode?): ListNode? {
        //自己的想法，先全部复制，在重新构建
        val map = HashMap<ListNode?, ListNode?>()
        var tail = node
        //先创建节点
        while (tail != null) {
            val value = tail.value
            map[tail] = ListNode(value)
            tail = tail.next
        }
        tail = node
        //步进取新节点重新构建
        while (tail != null) {
            val newNode = map[tail]
            newNode?.next = map[tail.next]
            newNode?.random = map[tail.random]
            tail = tail.next
        }

        return map[tail]
    }
}