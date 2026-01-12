package topics

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * Z 字形查找
 * 思路与算法
 *
 * 我们可以从矩阵 matrix 的右上角 (0,n−1) 进行搜索。在每一步的搜索过程中，如果我们位于位置 (x,y)，
 * 那么我们希望在以 matrix 的左下角为左下角、以 (x,y) 为右上角的矩阵中进行搜索，即行的范围为 [x,m−1]，列的范围为 [0,y]：
 *
 * 如果 matrix[x,y]=target，说明搜索完成；
 *
 * 如果 matrix[x,y]>target，由于每一列的元素都是升序排列的，那么在当前的搜索矩阵中，
 * 所有位于第 y 列的元素都是严格大于 target 的，因此我们可以将它们全部忽略，即将 y 减少 1；
 *
 * 如果 matrix[x,y]<target，由于每一行的元素都是升序排列的，那么在当前的搜索矩阵中，
 * 所有位于第 x 行的元素都是严格小于 target 的，因此我们可以将它们全部忽略，即将 x 增加 1。
 */
class Solution240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = matrix.size
        val col = matrix[0].size
        var x = 0
        var y = col - 1

        while (x < row && y >= 0) {
            val xyValue = matrix[x][y]
            if (xyValue == target) {
                return true
            } else if (xyValue < target) {
                x++
            } else {
                y--
            }
        }
        return false
    }
}