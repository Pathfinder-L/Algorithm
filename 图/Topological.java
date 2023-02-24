package 算法第四版.图;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:54
 *
 * */

/*拓扑排序*/
public class Topological
{
    private Iterable<Integer> order;

    public Topological(LinkedDiGraph g)
    {
        DirectedCycle cyclefinder = new DirectedCycle(g);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(g);
            order = dfs.reversePoST();
        }
    }

    /*判断是否为无环图*/
    public boolean isDAG()
    {
        return order != null;
    }

    /*拓扑排序当中所有的顶点*/
    Iterable<Integer> order()
    {
        return order;
    }
}
