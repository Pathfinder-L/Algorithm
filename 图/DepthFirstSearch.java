package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 14:45
 *
 * */
public class DepthFirstSearch extends Search
{

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s)
    {

        super(g, s);
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        count++;
        for (int w : g.adj(v))
        {
            if (!marked[w]) dfs(g, w);
        }
    }

    @Override
    boolean marked(int v)
    {
        return marked[v];
    }

    @Override
    int count()
    {
        return count;
    }
}
