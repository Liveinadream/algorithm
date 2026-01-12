package topics

import examination.ListNode
import examination.Node

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 使用双向链表，移除时，总是移除尾节点的前向节点
 */
class LRUCache(val capacity: Int) {
    val cacheMap = HashMap<Int, Node<Int>?>()

    //构建一个虚拟头尾，方便存取节点
    val head = Node(0)
    val tail = Node(0)

    init {
        head.next = tail
        tail.prev = head
    }

    private fun moveToHead(node: Node<Int>) {
        node.removeNode()
        addToHead(node)
    }

    private fun addToHead(node: Node<Int>) {
        val next = head.next
        //重新添加后向节点
        head.next = node
        node.next = next
        //重新添加前向节点
        node.prev = head
        next?.prev = node
    }

    fun get(key: Int): Int {
        val value = cacheMap[key]
        if (value != null) {
            //移动到头部
            moveToHead(value)
            return value.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        var node = cacheMap[key]
        if (node == null) {
            //大于时先从排序队列中取出使用次数最少的,再从map 中找到对应的 key,移除该 key
            if (cacheMap.size >= capacity) {
                val removeNode = tail.prev
                removeNode?.removeNode()
                cacheMap.remove(removeNode?.key)
            }
            node = Node(value)
            node.key = key
            addToHead(node)
            cacheMap[key] = node
        } else {
            node.value = value
            moveToHead(node)
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var tail = head.next
        while (tail != this.tail) {
            sb.append("value:")
                .append(tail?.value)
                .append("\n")
            tail = tail?.next
        }
        return sb.toString()
    }
}