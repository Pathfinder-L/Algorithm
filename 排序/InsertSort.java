package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:20
 *
 * */
// 插入排序
public class InsertSort
{

    public void sort(int[] nums)
    {
        for (int i = 1; i < nums.length; i++)
        {
            int val = nums[i], j = i;
            while (j - 1 > -1 && nums[j - 1] > val)
            {
                swap(nums, j, j - 1);
                j--;
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
