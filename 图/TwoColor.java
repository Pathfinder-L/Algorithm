package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:03
 *
 * */
/*判断是否为双色图*/
public class TwoColor
{
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph g)
    {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++)
        {
            if (!marked[s]) dfs(g, s);
        }
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        for (int w : g.adj(v))
        {
            if (!marked[w])
            {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) isTwoColorable = false;
        }
    }

    private boolean isBipartite()
    {
        return isTwoColorable;
    }
}
