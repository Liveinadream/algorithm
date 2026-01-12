package topics

import examination.ListNode

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 *
 */
class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        //自己想到的方法，用 set 记录，如果没有重复的就返回false
        val hashSet = HashSet<ListNode>()
        var node = head
        while (node?.next != null) {
            if (hashSet.contains(node)) {
                return true
            }
            hashSet.add(node)
            node = node.next
        }
        //方法2 快慢步
        var fast = head
        var slow = head
        do {
            fast = fast?.next?.next
            slow = slow?.next
        } while (fast != slow && fast != null)
        return fast != null
    }
}