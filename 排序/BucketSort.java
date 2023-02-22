package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:58
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 桶排序
public class BucketSort
{

    public void sort(int[] nums)
    {
        ArrayList<Integer>[] buckets = new ArrayList[110];
        int offSet = 50000;
        int size = 1000;
        for (int i = 0; i < nums.length; i++)
        {
            int idx = (nums[i] + offSet) / size;
            buckets[idx].add(nums[i]);
        }

        for (int i = 0; i < buckets.length; i++)
        {
            Collections.sort(buckets[i]);
        }

        int idx = 0;
        for (int i = 0; i < buckets.length; i++)
        {
            for (int j = 0; j < buckets[i].size(); j++)
                nums[idx++] = buckets[i].get(j);
        }
    }
}
