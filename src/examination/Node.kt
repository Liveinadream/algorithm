package examination

/**
 * 通用node
 */
class Node<T>(value: T, next: Node<T>? = null, previous: Node<T>? = null) {
    var value: T = value // value可以是任意类型
    var key : Int? = 0
    var next: Node<T>? = next // next可以为null
    var prev: Node<T>? = previous // pre也可以为null
    override fun toString(): String {
        return "{current value:$value next:${next?.value} previous:${prev?.value}}"
    }

    /**
     * 将自身从链表中移除
     */
    fun removeNode() {
        prev?.next = next
        next?.prev = prev
    }

}

class ListNode(var value: Int, node: ListNode? = null) {
    var next: ListNode? = node
    var random: ListNode? = null

    fun copyRandomList(): ListNode? {
        val randomValueCopy = random?.value
        if (randomValueCopy != null) {
            val copyRandom = ListNode(randomValueCopy)
            return copyRandom
        }
        return null
    }

    @Override
    override fun toString(): String {
        return "$value"
    }

    fun printAllNode() {
        var tail = this
        while (true) {
            println(tail.value)
            if (tail.next == null) {
                break
            }
            tail = tail.next!!
        }
    }
}

class CommonListNode<T>(var value: T) {
    var next: CommonListNode<T>? = null
}

/**
 * 将后原节点后节点与前面节点位置对换，并将其后节点替换为被代替的前节点位置
 */
//fun testNode() {
//    val linkList = mutableListOf<Node<Int>>()
//    val node1 = Node(1)
//    val node2 = Node(2)
//    val node3 = Node(3)
//    val node4 = Node(4)
////    val node5 = Node(5)
//    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node1
////    node5.next = node1
//    node1.previous = node4
//    node2.previous = node1
//    node3.previous = node2
//    node4.previous = node3
////    node5.previous = node4
//    linkList.add(node1)
//    linkList.add(node2)
//    linkList.add(node3)
//    linkList.add(node4)
////    linkList.add(node5)
//    val n = linkList.size
//    for (i in 0 until (n - 1) / 2) {
//        val left = 2 * i + 1
//        val right = n - 1
//        val leftNode = linkList[left]
//        val rightNode = linkList[right]
//        //处理原节点前后节点
//        leftNode.previous!!.next = rightNode
//        rightNode.previous!!.next = linkList[0]
//        linkList[0].previous = rightNode.previous
//        //处理变化节点
//        rightNode.next = leftNode
//        rightNode.previous = leftNode.previous
//        leftNode.previous = rightNode
//
//        linkList.removeAt(right)
//        linkList.add(left, rightNode)
//    }
//
//    for (i in 0 until n) {
//        println(linkList[i].toString())
//    }
//}