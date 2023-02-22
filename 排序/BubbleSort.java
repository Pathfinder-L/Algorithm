package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:31
 *
 * */
public class BubbleSort
{

    public void sort(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length - 1 - i; j++)
            {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
