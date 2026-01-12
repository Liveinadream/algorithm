package examination;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> sumTable = new HashMap<>();
        sumTable.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += sumTable.getOrDefault(sum - k, 0);
            sumTable.put(sum, sumTable.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0; // 当前位置
        int dx = 0, dy = 1; // 移动方向

        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = Integer.MIN_VALUE;

            // 检查是否需要改变方向
            int nextX = x + dx;
            int nextY = y + dy;
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix[nextX][nextY] == Integer.MIN_VALUE) {
                // 方向旋转90度： (dx, dy) → (dy, -dx)
                int temp = dx;
                dx = dy;
                dy = -temp;
            }

            x += dx;
            y += dy;
        }

        return res;
    }

//    private void addToHead(Node node) {
//        node.setPrevious(head); = ;
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
//    }


//    private void moveToHead(Node node) {
//        removeNode(node);
//        addToHead(node);
//    }


}

