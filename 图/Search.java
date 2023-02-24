package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 14:28
 *
 * */

import edu.princeton.cs.algs4.In;

/*查找算法*/
public abstract class Search
{

    private Graph g;
    private int source;

    public Search(Graph g, int s)
    {

    }

    abstract boolean marked(int v);

    abstract int count();

    public static void main(String[] args)
    {
        Graph g = new LinkedUdGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new DepthFirstSearch(g, s);

        for (int v = 0; v < g.V(); v++)
            if (search.marked(v))
            {
                System.out.print(v + " ");
            }
        System.out.println();
        if (search.count() != g.V()) System.out.print("Not ");
        System.out.println("connected");
    }
}
