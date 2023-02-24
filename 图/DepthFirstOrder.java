package 算法第四版.图;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 16:01
 *
 * */
public class DepthFirstOrder
{
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;


    public DepthFirstOrder(LinkedDiGraph g)
    {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();

        marked = new boolean[marked.length];

        for (int v = 0; v < g.V(); v++)
        {
            if (!marked[v]) dfs(g, v);
        }

    }

    private void dfs(LinkedDiGraph g, int v)
    {
        pre.add(v);
        marked[v] = true;

        for (int w : g.adj(v))
        {
            if (!marked[w])
            {
                dfs(g, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre()
    {
        return pre;
    }

    public Iterable<Integer> post()
    {
        return post;
    }

    public Iterable<Integer> reversePoST()
    {
        return reversePost;
    }

}
