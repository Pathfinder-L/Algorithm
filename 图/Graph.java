package 算法第四版.图;

import java.util.Iterator;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 10:31
 *
 * */
public abstract class Graph
{

    abstract int V();

    abstract int E();

    abstract void addEdge(int v, int w);

    abstract Iterable<Integer> adj(int v);

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder(V() + " vertices , " + E() + " " +
                "edges\n");
        for (int v = 0; v < V(); v++)
        {
            s.append(v).append(":");
            for (int w : this.adj(v))
            {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static int degree(Graph g, int v)
    {
        int degree = 0;
        for (int w : g.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph g)
    {
        int max = 0;
        for (int v = 0; v < g.V(); v++)
        {
            if (degree(g, v) > max) max = degree(g, v);
        }
        return max;
    }


}
