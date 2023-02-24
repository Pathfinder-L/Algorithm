package 算法第四版.图;

import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;
import java.util.List;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 16:27
 *
 * */
public class EdgeWeightGraph extends Graph
{

    private final int V;
    private int E;
    private ArrayList<Edge>[] adj;


    public EdgeWeightGraph(int V)
    {
        super();
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Edge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
        {
            adj[v] = new ArrayList<>();
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


    @Override
    void addEdge(int v, int w)
    {

    }

    void addEdge(Edge e)
    {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    @Override
    Iterable<Integer> adj(int v)
    {
        return null;
    }

    Iterable<Edge> getAdj(int v)
    {
        return adj[v];
    }

    public Iterable<Edge> edges()
    {
        Bag<Edge> b = new Bag<>();
        for (int v = 0; v < V; v++)
        {
            for (Edge e : adj[v])
                if (e.other(v) > V) b.add(e);
        }
        return b;
    }
}
