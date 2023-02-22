package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:03
 *
 * */
public class QuickSort
{

    public void quicksort(int[] nums)
    {
        sort(nums,0,nums.length-1);
    }

    public void sort(int[] nums, int lo, int hi)
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
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
