package topics

import examination.ListNode
import java.util.TreeSet

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
class Solution148 {
    fun sortList(head: ListNode?): ListNode? {
        if(head == null || head.next == null){
            return head
        }
        var tail = head
        val treeSet = mutableListOf<ListNode>()
        val comparator = Comparator<ListNode>({ a, b ->
            if (a.value < b.value) {
                return@Comparator -1
            } else if (a.value == b.value) {
                return@Comparator 0
            }
            return@Comparator 1
        })
        while (tail != null) {
            treeSet.add(tail)
            tail = tail.next
        }
        val sortList = treeSet.sortedWith(comparator)
        var cur: ListNode? = null
        val head: ListNode = sortList[0]
        sortList[sortList.lastIndex].next = null
        for (i in sortList.indices) {
            val next = sortList[i]
            if (cur != null) {
                cur.next = next
            }
            cur = next
        }
        head.printAllNode()
        return head
    }
}