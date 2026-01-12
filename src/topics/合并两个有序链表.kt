package topics

import examination.CommonListNode

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class Solution21 {
    fun mergeTwoLists(list1: CommonListNode<Int>?, list2: CommonListNode<Int>?): CommonListNode<Int>? {
        //自己的想法，拿到当前最小节点作为头部，然后让该节点依次与 list1 list2 中的小节点组合
        var node1 = list1
        var node2 = list2
        var currentNode: CommonListNode<Int>? = if (node1 == null) {
            node2
        } else if (node2 == null) {
            node1
        } else if (node1.value <= node2.value) {
            node1
        } else {
            node2
        }
        val returnNode = currentNode
        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                if (currentNode != node1) {
                    currentNode?.next = node1
                }
                currentNode = node1
                node1 = node1.next
                if (node1 == null) {
                    currentNode.next = node2
                }
            } else {
                if (currentNode != node2) {
                    currentNode?.next = node2
                }
                currentNode = node2
                node2 = node2.next
                if (node2 == null) {
                    currentNode.next = node1
                }
            }
        }
        return returnNode
    }
}