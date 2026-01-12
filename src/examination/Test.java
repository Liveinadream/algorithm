package examination;

import java.util.*;

/**
 * 输入N,T
 * N 是任务数，T 是最晚完成时间
 * 给定 N 个 SLAV 计算最大积分
 * 解：将任务按照积分排序
 * 便利积分数组，尝试完成最大积分任务，
 * 总是将完成的最大积分任务这个 T 的数组中 的第 V 位，如果已经有值，那么使用递归尝试向前一位添加
 * 测试数据：
 * 2
 * 2
 * 1 3
 * 2 4
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        in.nextLine();
        int[] questT = new int[T];
        ArrayList<Integer[]> list = new ArrayList<>();
        //对任务进行排序
        for (int i = 0; i < N; i++) {
            String SLAV = in.nextLine();
            String[] array = SLAV.split(" ");
            Integer[] intArray = new Integer[2];
            intArray[0] = Integer.parseInt(array[0]);
            intArray[1] = Integer.parseInt(array[1]);
            list.add(intArray);
        }
        list.sort((o1, o2) -> {
            if (o2[1] > o1[1]) {
                return 1;
            } else if (o2[1] < o1[1]) {
                return -1;
            }
            return 0;
        });
        //对任务进行放置
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i)[1]);
            putQuest(list.get(i), questT);
        }
        //对 questT 数组中的值进行相加，得到最大积分
        int total = 0;
        for (int j : questT) {
//            System.out.println(total);
            total += j;
        }
        System.out.println(total);
    }

    public static void putQuest(Integer[] quest, int[] questT) {
        //任务时间超过了最大值
        if(quest[0] > questT.length){
            return;
        }
        //对应时间未知没有值，那么放入该最大积分,时间数组是从0开始的
        if (questT[quest[0]-1] == 0) {
            questT[quest[0]-1] = quest[1];
            // System.out.println("add num:"+quest[1] + " add position:"+(quest[0]-1));
            return;
        }
        //否则向前一位并进行任务时间对比，如果没有值，并且时间合理，那么添加
        tryPutQuest(quest, questT, quest[0] - 2);
    }

    public static void tryPutQuest(Integer[] quest, int[] questT, int position) {
        //放置位置不在合理时，进行遗弃
        if (position < 0) {
            return;
        }
        if (questT[position] == 0) {
            questT[position] = quest[1];
            // System.out.println("add num:"+quest[1] + " add position:"+(position));
            return;
        }
        tryPutQuest(quest, questT, position - 1);
    }
}