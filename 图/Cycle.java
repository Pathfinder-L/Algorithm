package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:07
 *
 * */
/*判断图是否有环路*/
public class Cycle
{
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph g)
    {
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++)
        {
            if (!marked[s])
            {
                dfs(g, s, s);
            }
        }
    }


    // 假设不存在自环和平行边
    private void dfs(Graph g, int v, int u)
    {
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w])
            {
                dfs(g, w, v);
            } else if (w != u) hasCycle = true;
    }

    public boolean hasCycle()
    {
        return hasCycle; // 判断是否含有环路
    }
}
