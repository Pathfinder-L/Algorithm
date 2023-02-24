package 算法第四版.图;

import edu.princeton.cs.algs4.IndexMinPQ;


/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 17:20
 *
 * */
public class PrimMST
{
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightGraph g)
    {
        edgeTo = new Edge[g.V()];
        distTo = new double[g.V()];
        marked = new boolean[g.V()];

        for (int v = 0; v < g.V(); v++)
        {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq = new IndexMinPQ<>(g.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty())
        {

        }
    }

    private void visit(EdgeWeightGraph G, int v)
    {
        marked[v] = true;
        for (Edge e : G.getAdj(v))
        {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w])
            {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }


}
