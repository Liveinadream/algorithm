package topics

import examination.ListNode
import jdk.nashorn.internal.ir.ReturnNode

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if(k == 1){
            return  head
        }
        return getNewList(head, null, k, null)
    }

    /**
     * @param head 最新的头
     * @param lastNode  上次反转后的节点末位，也就是未反转的起始位置
     * @param k
     * @param returnNode 最终要返回的节点
     */
    fun getNewList(head: ListNode?, lastNode: ListNode?, k: Int, returnNode: ListNode? = null): ListNode? {
        //自己想到的方法，快慢步，快步总是比慢步，要快 K 个节点，创建 虚拟节点 dummy 如果快步为空,则代表剩余节点无需反转
        val dummy = ListNode(0, head)
        var tail: ListNode? = dummy
        var kStep = k
        while (kStep > 0 && tail != null) {
            tail = tail.next
            kStep--
        }
        //无法步进 k 步时
        if (tail == null) {
            if (lastNode != null) {
                lastNode.next = head
            }
            return returnNode ?: dummy.next
        } else {
            //能够步进 k 步
            kStep = k
            //获得上次的最终节点
            var lastNode1 = lastNode
            //获得之前的要返回的节点
            var returnNode1 = returnNode
            var newHead = head
            tail = head?.next
            head?.next = lastNode

            while ((kStep - 1) > 0) {
                kStep--
                //反转指向
                val temp = tail?.next
                tail?.next = newHead
                newHead = tail
                if (kStep - 1 == 0) {
                    if (returnNode1 == null) {
                        //需要赋值给 returnNode
                        returnNode1 = tail
                    }
                    if (lastNode1 != null) {
                        lastNode1.next = tail
                    }
                    //这一次的尾巴
                    lastNode1 = head
                    //下一次的头
                    newHead = temp
                }
                tail = temp
            }
            return getNewList(newHead, lastNode1, k, returnNode1)
        }
    }
}