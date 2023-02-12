package 算法框架.动态规划;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2022/6/17 11:50
 *
 * */

import org.junit.Test;
import 工具.Print;

import java.util.*;

// 动态规划问题
public class Solution {


    // 动态规划求解背包问题
    public static int rob_2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int len = nums.length;
        int[] dp = new int[len - 1];
        int[] dp1 = new int[len - 1];
        // 如果选中了第一个房间
        dp[0] = nums[0];
        dp[1] = nums[0];
        // 选中了第一个房子
        System.out.println("选中第一个房子");
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        for (int i = 0; i < dp.length; i++) System.out.print(dp[i] + " ");

        System.out.println();

        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[1], nums[2]);
        // 没有选中第一个房子
        System.out.println("没有选中第一个房子");
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i + 1]);
        }
        for (int i = 0; i < dp1.length; i++) System.out.print(dp1[i] + " ");
        return Math.max(dp1[dp1.length - 1], dp[dp.length - 1]);
    }

    // f(x)= max(f(x-1), f(x-2...0)+ v(x))
    // 偷东西的最优选择
    public static int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        for (int i = 0; i < dp.length; i++) System.out.print(" " + dp[i]);
        return dp[len - 1];
    }


    // 最小路径和
    public int minPathSum(int[][] grid) {

        // 先进行合法判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 初始化备忘录
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        // 初始化第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 初始化第一行
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 或者最后的备忘录
        // 动态转移返程为
        // f(i)(j) = Min(dp[i-1][j],dp[i][j-1])
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 终点的值
        return dp[rows - 1][columns - 1];
    }


    // 1
    // 1,1
    // 1,2,1
    // 1,3,3,1
    // 1,4,6
    // 杨辉三角
    public List<List<Integer>> generate(int numRows) {

        // 直接用列表作为动态规划的备忘录

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    // 1,1,2,3,5
    // 求解Fibonacci数
    public static int fib(int N) {
        if (N == 0) return 0;
        int[] mem = new int[N + 1];
        return fibHelper(mem, N);
    }


    // 自定向上的动态规划
    public static int fibHelper(int[] mem, int n) {
        if (n == 1 || n == 2) return 1;
        if (mem[n] != 0) return mem[n];
        mem[n] = fibHelper(mem, n - 1) + fibHelper(mem, n - 2);
        return mem[n];
    }

    public static int fibIterative(int n) {
        // 先进行判断
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // 创建备忘录
        int[] mem = new int[n + 1];
        // base case
        mem[1] = 1;
        mem[2] = 1;

        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }


    // 筹零钱的问题,用最少的纸张，筹钱
    public static int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        coins = new int[4];
        // base case
        // amount  = 0
        coins[1] = 1;
        coins[2] = 2;
        coins[3] = 5;
        int ans = coinChangeHelper(coins, amount, mem);
        return ans;
    }

    public static int coinChangeHelper(int[] coins, int amount, int[] mem) {
        // 基础条件
        if (amount == 1 || amount == 2 || amount == 5) return 1;
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (mem[amount] != 0) return mem[amount];
        mem[amount] = Math.min(Math.min(coinChangeHelper(coins, amount - coins[1], mem),
                        coinChangeHelper(coins, amount - coins[2], mem)),
                coinChangeHelper(coins, amount - coins[3], mem)) + 1;

        return mem[amount];
    }


    // 动态规划求解最长的斐波拉契序列
    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }


    // 接雨水
    // 2o(n) 的时间预处理
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        //Print.PrintArr(leftMax);

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        //  Print.PrintArr(rightMax);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return ans;
    }


    @Test
    public void testUniquePathsWithObstacles() {
        int[][] map = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] map2 = new int[][]{
                {0, 1},
                {0, 0}
        };

        uniquePathsWithObstacles(map);
        uniquePathsWithObstacles(map2);

    }

    //不同的路径
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length, w = obstacleGrid[0].length;
        int[][] dp = new int[h][w];
        int i = 0;
        while (i < h && obstacleGrid[i][0] != 1) dp[i++][0] = 1;
        i = 0;
        while (i < w && obstacleGrid[0][i] != 1) dp[0][i++] = 1;
        for (int j = 1; j < h; j++) {
            for (int k = 1; k < w; k++) {
                if (obstacleGrid[j][k] != 1) dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
            }
        }

        //    Print.PrintMatrix(dp);

        int ans = dp[h - 1][w - 1];
        //    System.out.println("ans:" + ans);
        return ans;
    }


    @Test
    public void testNumDecoding() {
        String s = "1";
        numDecodings(s);
    }

    // 解码的方法
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        Print.PrintString(s);
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        if (len > 1 && s.charAt(1) != '0') dp[1]++;
//        System.out.println("dp[1]" + dp[1]);
        if (len > 1 && (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6'))) dp[1]++;
        //       System.out.println("dp[1]" + dp[1]);
        if (len > 1 && dp[1] == 0) return 0;
        for (int i = 2; i < len; i++) {
            boolean f1 = false, f2 = false;
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
                f1 = true;
            }
            if ((s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i] += dp[i - 2];
                f2 = true;
            }
            if (!(f1 || f2)) return 0;
        }

        int ans = dp[len - 1];
        Print.PrintArr(dp);
        System.out.println("ans:" + ans);
        return 1;
    }

    public int numDecodings_v2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1; // 空字符串的情况
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }


    // 替换零钱
    public int coinChang(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    @Test
    public void testMinCostClimbingStairs() {
        int[] arr = new int[]{
                10, 15, 20};
        minCostClimbingStairs(arr);
    }


    //


    @Test
    public void testDeleteAndEarn() {
        int[] nums = new int[]{
                2, 2, 3, 3, 3, 4
        };
        deleteAndEarn(nums);
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null) return 0;
        int maxValue = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            maxValue = Math.max(nums[i], maxValue);
        }

        int[] map = new int[maxValue];

        for (int i = 0; i < len; i++) {
            map[nums[i] - 1] += nums[i];
        }
        Print.PrintArr(map);
        getMax(map);
        return 0;
    }


    public int getMax(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max((dp[i - 2] + nums[i]), dp[i - 1]);
        }
        Print.PrintArr(dp);
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] height = new int[]{
                3, 0, 5, 2, 8, 0, 12
        };
        trap(height);
    }
}
