/**
 * @author zhangtianning
 */
public class Byte2HexJava {

    public static void main(String args[]) {

        byte[] b = new byte[5];
        b[0] =70;
        b[1] =81;
        b[2] =11;
        b[3] =14;
        b[4] =31;

       System.out.print("打印转换后的字符串:"+byte2hex(b));

    }
    private static String byte2hex(byte[] b) {// 二进制转字符串
        StringBuilder sb = new StringBuilder();
        String stmp = "";
        for (byte aB : b) {
            stmp = Integer.toHexString(aB & 0XFF);
            if (stmp.length() == 1) {
                sb.append("0").append(stmp);
            } else {
                sb.append(stmp);
            }
        }
        return sb.toString();
    }
}
