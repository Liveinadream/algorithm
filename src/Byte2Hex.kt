import kotlin.experimental.and

object Byte2Hex {
    @JvmStatic
    fun main(args: Array<String>) {
        val b = ByteArray(5)
        b[0] = 70
        b[1] = 81
        b[2] = 11
        b[3] = 14
        b[4] = 31

        print("打印转换后的字符串:${byte2hex(b)}")

    }

    fun byte2hex(b: ByteArray): String {// 二进制转字符串
        val sb = StringBuffer()
        var stmp: String
        for (n in b.indices) {
            stmp = Integer.toHexString((b[n] and (0XFF.toByte())).toInt())
            if (stmp.length == 1) {
                sb.append("0$stmp")
            } else {
                sb.append(stmp)
            }
        }
        return sb.toString()
    }
}