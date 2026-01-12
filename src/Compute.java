/**
 * @author zhangtianning
 */
public class Compute {


    /**
     * 加法
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 减法
     */
    public int minus(int a, int b) {
        return a - b;
    }

    /**
     * 乘法
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * 除法
     */
    public int divided(int a, int b) {
        return a / b;
    }

    /**
     * 多参数
     */
    public int add(int... values) {
        int add = 0;
        for (int value : values) {
            add += value;
        }
        return add;
    }
}
