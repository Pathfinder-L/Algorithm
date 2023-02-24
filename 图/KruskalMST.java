package 算法第四版.图;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 17:33
 *
 * */
public class KruskalMST extends MST
{

    private Queue<Edge> mst;


    public KruskalMST(EdgeWeightGraph graph)
    {
        super(graph);
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge edge : graph.edges())
        {
            pq.insert(edge);
        }
        UF uf = new UF(graph.V());

        while (!pq.isEmpty() && mst.size() < graph.V() - 1)
        {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
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
