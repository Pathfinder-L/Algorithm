package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 10:43
 *
 * */

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

// 邻接链表实现图

public class LinkedUdGraph extends Graph
{
    private final int V; // 节点
    private int E; // 边
    private List[] adj;


    public LinkedUdGraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }

    public LinkedUdGraph(In in)
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


    // 无向图
    @Override
    void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v)
    {
        return adj[v];
    }
}
