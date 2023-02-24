package 算法第四版.图;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 17:10
 *
 * */
public class LazyPrimMST extends MST
{

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightGraph G)
    {
        super(G);
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);
        while (!pq.isEmpty())
        {
            Edge edge = pq.delMin();
            int v = edge.either(), w = edge.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(edge);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightGraph g, int v)
    {
        marked[v] = true;
        for (Edge e : g.getAdj(v))
        {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    @Override
    public Iterable<Edge> edges()
    {
        return mst;
    }

    @Override
    public double weight()
    {
        return 0;
    }
}
