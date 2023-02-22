package 算法第四版.排序;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/22 21:37
 *
 * */

/*堆排序*/
public class HeapSort
{

    private int[] heap;
    private int size;

    public void sort(int[] nums)
    {
        this.heap = new int[nums.length + 1];
        this.size = 0;

        for (int i = 0; i < nums.length; i++)
            build(nums[i]);

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = heap[1];
            swap(heap, 1, size--);
            down(1);
        }
    }


    public void up(int son)
    {
        int fa = son >> 1;
        while (fa != 0)
        {
            if (heap[fa] > heap[son])
            {
                swap(heap, fa, son);
                son = fa;
                fa >>= 1;
            } else break;
        }
    }

    public void down(int idx)
    {
        int son = idx * 2;
        if (son > size) return;
        if (son + 1 <= size && heap[son + 1] < heap[son]) son++;
        if (heap[son] < heap[idx])
        {
            swap(heap, son, idx);
            down(son);
        }
    }

    public void build(int e)
    {
        heap[++size] = e;
        up(size);
    }

    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
