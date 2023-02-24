package 算法第四版.图;

import edu.princeton.cs.algs4.MinPQ;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 16:20
 *
 * */
public abstract class MST
{
    private boolean[] marked;
    private Queue<Edge> mst;
    private PriorityQueue<Edge> pq;

    public MST(EdgeWeightGraph G)
    {

    }

    public abstract Iterable<Edge> edges();

    public abstract double weight();


}
