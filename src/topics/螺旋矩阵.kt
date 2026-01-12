package topics

class Solution54 {
    fun spiralOrder(matrix: Array<IntArray?>?): MutableList<Int> {
        val res = mutableListOf<Int>()
        if (matrix == null || matrix.isEmpty() || matrix[0]!!.isEmpty()) {
            return res
        }

        val m = matrix.size
        val n = matrix[0]!!.size
        var x = 0
        var y = 0 // 当前位置
        var dx = 0
        var dy = 1 // 移动方向

        for (i in 0 until m * n) {
            res.add(matrix[x]!![y])
            //记录已被使用的数位最小Int
            matrix[x]!![y] = Int.MIN_VALUE

            // 检查是否需要改变方向
            val nextX = x + dx
            val nextY = y + dy
            //判断是否应该转向
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix[nextX]!![nextY] == Int.MIN_VALUE) {
                // 方向旋转90度： (dx, dy) → (dy, -dx)
                val temp = dx
                dx = dy
                dy = -temp
            }

            x += dx
            y += dy
        }
        return res
    }
}