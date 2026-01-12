import java.text.DecimalFormat;
import java.util.Scanner;

public class test1 {

    public static void main(String args[]) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        Scanner input = new Scanner(System.in);
        System.out.print("\n请输入计算的数据个数\n");
        //声明一个大小为用户输入大小的数组
        double[] nums = new double[setNums(input)];

        System.out.print("\n请输入接下来的几个数字\n");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextDouble();
        }
        
        double s = 0;
        for (int num = 0; num < nums.length; num++) {
            s += nums[num];
            System.out.print("\n" + df.format(s / (num + 1)));
        }

    }

    /**
     * 获取一个正整数
     *
     * @param input 输入
     * @return 正整数
     */
    public static int setNums(Scanner input) {

        int num = input.nextInt();
        if (num <= 0) {
            System.out.print("\n请输入一个正确的数字\n");
            num = setNums(input);
        }
        return num;
    }
}
