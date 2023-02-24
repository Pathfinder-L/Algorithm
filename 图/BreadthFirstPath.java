package 算法第四版.图;

import java.util.LinkedList;
import java.util.Queue;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 14:50
 *
 * */
public class BreadthFirstPath extends Search
{

    private boolean[] marked;
    private int[] edgeTo;
    private final int s; //


    public BreadthFirstPath(Graph g, int s)
    {
        super(g, s);
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s)
    {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty())
        {
            int v = queue.poll();
            for (int w : g.adj(v))
            {
                if (!marked(w))
                {
                    edgeTo[w] = v;
                    marked[w] = true; // 标记最短路的最后一条边
                    queue.add(w);
                }
            }
        }
    }


    public boolean hasPathTo(int v)
    {
        return marked[v];
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
