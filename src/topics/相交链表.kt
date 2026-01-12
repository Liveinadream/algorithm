package topics

import examination.ListNode

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 *
 * 最简思路
 * 当链表 headA 和 headB 都不为空时，创建两个指针 pA 和 pB，
 * 初始时分别指向两个链表的头节点 headA 和 headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
 * 每步操作需要同时更新指针 pA 和 pB。
 *
 * 如果指针 pA 不为空，则将指针 pA 移到下一个节点；如果指针 pB 不为空，则将指针 pB 移到下一个节点。
 *
 * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
 *
 * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
 *
 * 即有相交节点时总题步数相同
 *
 * A B C D E
 * C D E
 *
 * A B C D E C D E
 * C D E A B C D E
 */
class Solution160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        //自己的思路，利用 hashSet 遍历
        var aTemp: ListNode? = headA
        var bTemp: ListNode? = headB
        val aSet = HashSet<ListNode?>()
        aSet.add(headA)
        while (aTemp != null) {
            aTemp = aTemp.next
            aSet.add(aTemp)
        }
        while (bTemp != null) {
            if (aSet.contains(bTemp)) {
                return bTemp
            }
            bTemp = bTemp.next
        }
        //最简空间思路
        var pA: ListNode? = headA
        var pB: ListNode? = headB
        while (pA != pB) {
            pA = if (pA == null) headB else pA.next
            pB = if (pB == null) headA else pB.next
        }
        return pA
    }


}

