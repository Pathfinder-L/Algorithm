package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:42
 *
 * */

/*有向图的可达性*/
public class DirectedDFS extends Search
{
    private boolean[] marked;

    public DirectedDFS(LinkedDiGraph graph, int s)
    {
        super(graph, s);
        marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    private void dfs(LinkedDiGraph g, int v)
    {
        marked[v] = true;
        for (int w : g.adj(v))
        {
            if (!marked(w)) dfs(g, w);
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
        return 0;
    }
}
