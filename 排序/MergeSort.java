package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/18 20:59
 *
 * */


public class MergeSort
{
    private int[] aux;


    // 递归版本
    public void sort(int[] nums)
    {
        aux = new int[nums.length];

    }

    public void mergeSortV1(int[] nums, int lo, int hi)
    {
        if(hi <= lo) return;
        int mid = lo + (hi - lo )/2;
        mergeSortV1(nums,lo,mid);
        mergeSortV1(nums,mid+1,hi);

        int i = lo, j = mid + 1, k = i;
        while (i <= mid && j <= hi)
        {
            if (nums[i] < nums[j]) aux[k++] = nums[i++];
            else aux[k++] = nums[j++];
        }

        while (i <= mid) aux[k++] = nums[i++];
        while (j <= hi) aux[k++] = nums[j++];

        for (i = lo; i <= hi; i++)
        {
            nums[i] = aux[i];
        }
        // show(nums);
    }

    public static void mergeSortV2(int[] nums)
    {

        int[] aux = new int[nums.length];
        for (int sz = 1; sz < nums.length; sz += sz)
        {
            for (int left = 0; left + sz < nums.length; left += sz * 2)
            {
                int l = left, r = left + sz, k = left;
                int R = Math.min(left + sz * 2, nums.length), L = left + sz;

                while (l < L && r < R)
                {
                    if (nums[l] < nums[r]) aux[k++] = nums[l++];
                    else aux[k++] = nums[r++];
                }

                while (l < L) aux[k++] = nums[l++];
                while (r < R) aux[k++] = nums[r++];
                for (k = left; k < R; k++)
                    nums[k] = aux[k];
            }
            if (sz * 2 >= nums.length) break;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
