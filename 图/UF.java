package 算法第四版.图;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 17:35
 *
 * */
/*union find*/
public class UF
{
    private int[] id;
    private int count;
    private int[] sz;


    public UF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);

        if (i == j) return;
        if (sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        } else
        {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    private int find(int p)
    {
        while (p != id[p]) id[p] = find(id[p]);
        return p;
    }

}
