package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 16:11
 *
 * */
public class KosarajuSCC
{
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(LinkedDiGraph g)
    {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        for (int s : order.reversePoST())
        {
            if (!marked[s])
            {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(LinkedDiGraph g, int v)
    {
        marked[v] = true;
        for (int w : g.adj(v))
        {
            if (!marked(w)) dfs(g, w);
        }
    }


    public boolean stronglyConnected(int v, int w)
    {
        return id[v] == id[w];
    }

    public int id(int v)
    {
        return id[v];
    }

    boolean marked(int v)
    {
        return marked[v];
    }

    public int count()
    {
        return count;
    }

}
