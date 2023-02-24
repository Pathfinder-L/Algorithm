package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:47
 *
 * */

import java.util.Stack;

/*判断有向图是否有环*/
public class DirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(LinkedDiGraph g)
    {
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++)
            if (!marked[v]) dfs(g, v);
    }

    private void dfs(LinkedDiGraph g, int v)
    {
        onStack[v] = true;
        marked[v] = true;

        for (int w : g.adj(v))
        {
            if (this.hasCycle()) return;
            else if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w])
            {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                {
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(w);
            }
        }
        onStack[v] = false;
    }


    public boolean hasCycle()
    {
        return cycle != null;
    }

    public Iterable<Integer> cycle()
    {
        return cycle;
    }
}
