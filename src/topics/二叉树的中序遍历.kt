package topics

import examination.TreeNode
import java.util.*

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        //1直接递归完成
        val list = mutableListOf<Int>()
        needAddRootNode(root, list)
        //2，自己构建一个栈
        var root = root
        val res: MutableList<Int?> = ArrayList<Int?>()
        val stk: Deque<TreeNode?> = LinkedList<TreeNode?>()
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root)
                root = root.left
            }
            root = stk.pop()
            res.add(root?.`val`)
            root = root?.right
        }
        return list
    }

    fun needAddRootNode(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        needAddRootNode(root.left, list)
        list.add(root.`val`)
        needAddRootNode(root.right, list)
    }
}