package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:39
 *
 * */

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

// 有向图
public class LinkedDiGraph extends Graph
{

    private final int V; // 节点
    private int E; // 边
    private List[] adj;


    public LinkedDiGraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }

    public LinkedDiGraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    @Override
    int V()
    {
        return V;
    }

    @Override
    int E()
    {
        return E;
    }


    // 返回图的反向图
    public LinkedDiGraph reverse()
    {
        LinkedDiGraph g = new LinkedDiGraph(V);
        for (int v = 0; v < V; v++)
        {
            for (int w : adj(v))
            {
                g.addEdge(w, v);
            }
        }
        return g;
    }



    // 无向图
    @Override
    void addEdge(int v, int w)
    {
        adj[v].add(w);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
}
