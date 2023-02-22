package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:10
 *
 * */

import java.util.Random;

// 快速选择算法
public class QuickSelect
{


    public void sort(int[] nums, int lo, int hi)
    {
        if (lo >= hi) return;
        int pos = randomizedPartition(nums, lo, hi);
        sort(nums, lo, pos - 1);
        sort(nums, pos + 1, hi);
    }

    public int randomizedPartition(int[] nums, int l, int r)
    {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, l, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int lo, int hi)
    {
        int P = nums[lo];
        int i = lo, j = hi + 1;

        while (i < j)
        {
            while (i < j && nums[--j] > P) ;
            while (i < j && nums[++i] < P) ;
            if (i < j)
            {
                swap(nums, i, j);
            }
        }
        swap(nums, lo, j);
        return j; // 主元的坐标
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
