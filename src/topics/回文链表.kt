package topics

import examination.ListNode

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
class Solution234 {
    fun isPalindrome(head: ListNode?): Boolean {
        //方法1 复制到数组，比较数组头尾的值
//        val array = mutableListOf<ListNode?>()
//        var headNext: ListNode? = head
//        while (headNext != null) {
//            array.add(headNext)
//            headNext = headNext.next
//        }
//
//        for (i in array.indices) {
//            if (array[i]?.value != array[array.lastIndex - i]?.value) {
//                return false
//            }
//        }

        //方法2,使用快慢步，得到中间值,
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next!!.next
            slow = slow?.next
        }
        var last = slow
        var next = slow?.next
        slow?.next = null
        //反转 halfHead 后的链表，最后的last 就是反转后的头
        while (next != null) {
            val tempNext = next.next
            next.next = last
            last = next
            next = tempNext
        }
        slow = head
        if(last?.next == null ){
            return last == head
        }
        //依次比较反转后的值,反转后的链表没有值了，说明没有可以比较的了
        while (last?.next != null) {
            if (slow?.value != last.value) {
                return false
            }
            slow = slow.next
            last = last.next
        }
        return true
    }
}
