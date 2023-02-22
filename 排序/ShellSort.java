package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:25
 *
 * */
// 希尔排序
public class ShellSort
{

    public void sort(int[] nums)
    {
        int h = 1;
        while (h * 3 + 1 < nums.length) h = h * 3 + 1;

        while (h != 0)
        {
            for (int i = h; i < nums.length; i++)
            {
                int j = i;
                while (j - h > -1 && nums[j] < nums[j - h])
                {
                    swap(nums, j, j - h);
                    j -= h;
                }
            }
            h /= 3;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
