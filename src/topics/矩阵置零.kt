package topics

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 方法二：使用两个标记变量
 * 思路和算法
 *
 * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。
 * 但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。
 * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
 *
 * 在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，
 * 然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。

 */
class Solution73 {
    fun setZeroes(matrix: Array<IntArray>) {
        //自己的想法，标记 mn 0所在的行和列，需要两次循环 空间复杂度 M+N
        val mZeroArray = IntArray(matrix.size) { -1 }
        val nZeroArray = IntArray(matrix[0].size) { -1 }
        for (i in matrix.indices) {
            val intArray = matrix[i]
            for (j in intArray.indices) {
                if (intArray[j] != 0) {
                    continue
                }
                mZeroArray[i] = 0
                nZeroArray[j] = 0
            }
        }

        for (i in matrix.indices) {
            val intArray = matrix[i]
            for (j in intArray.indices) {
                if (intArray[j] == 0) {
                    continue
                }
                if (mZeroArray[i] == 0 || nZeroArray[j] == 0) {
                    intArray[j] = 0
                }
            }
        }
        //使用方法2
        val m: Int = matrix.size
        val n: Int = matrix[0].size
        //横向是否含0
        var flagRow0 = false
        //纵向是否含0
        var flagCol0 = false
        //1.进行标记
        for (i in matrix.indices) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break
            }
        }

        for (i in matrix[0].indices) {
            if (matrix[0][i] == 0) {
                flagRow0 = true
                break
            }
        }
        //2.忽略第一行，第一列，开始进行转换，并仿照方法1用第一行，第一列进行记录0
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = matrix[0][j]
                }
            }
        }
        //3.进行替换
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
        //4.根据两个标记进行替换
        if (flagCol0) {
            for (i in matrix) {
                i[0] = 0
            }
        }
        if (flagRow0) {
            for (i in matrix[0].indices) {
                matrix[0][i] = 0
            }
        }
    }
}