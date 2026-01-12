package topics

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 0 1 2
 * 1 2 0
 * 2 1 0
 * --->
 * 2 1 0
 * 1 2 1
 * 0 0 2
 *
 * 解：
 * 设定方形矩阵元素为 n
 * 对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置，即 copyArray[j][n-i-1] = matrix[i][j]
 * i=j
 * j=n−i−1
 *
 * 由此可知，若是直接赋值，matrix[j][n-i-1] 将被覆盖，所以使用临时变量 temp 记录
 * 不断旋转被旋转的值，
 * matrix[i][j]
 * matrix[j][n-i-1]
 * matrix[n-i-1][n-j-1]
 * matrix[n-j-1][i]
 * 至此，一个元素的变化结束
 * 使用temp 记录原数字，可得
 * temp = matrix[i][j]
 * matrix[i][j] = matrix[n-j-1][i]
 * matrix[n-j-1][i] = matrix[n-i-1][n-j-1]
 * matrix[n-i-1][n-j-1] = matrix[j][n-i-1]
 * matrix[j][n-i-1] = temp
 *
 * 方法三：用翻转代替旋转
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 先将其通过水平轴翻转得到：
 * 7 8 9
 * 4 5 6
 * 1 2 3
 * 再根据主对角线翻转得到：
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * 即可得到原数组
 */
class Solution48 {
    fun rotate(matrix: Array<IntArray>) {
        //使用辅助矩阵
        val n = matrix.size
        //不能使用 matrix.copyOf() 这个元素指向的原本的数组，会直接修改原有元素
        val matrixNew = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                val temp = matrix[j][n - i - 1]
                matrix[j][n - i - 1] = matrix[i][j]
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = matrixNew[i][j]
            }
        }
        //不使用辅助矩阵
        for (i in 0 until n / 2) {
            for (j in 0 until (n + 1) / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[n - j - 1][i]
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]
                matrix[j][n - i - 1] = temp
            }
        }
        //方法3 旋转法
        for (i in 0 until n / 2) {
            for (j in 0 until n) {
                val temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        for (i in 0 until n) {
            for (j in 0 until i) {
                val temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


}