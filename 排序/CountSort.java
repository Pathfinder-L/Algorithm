package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:53
 *
 * */
public class CountSort
{
    private int[] aux;

    public void sort(int[] nums)
    {
        int offSet = 50000;
        aux = new int[100010];
        for (int i = 0; i < nums.length; i++)
            aux[nums[i] - offSet]++;

        int idx = 0;
        for (int i = 0; i < aux.length; i++)
        {
            while (aux[i]-- != 0)
            {
                nums[idx++] = i + offSet;
            }
        }
    }
}
