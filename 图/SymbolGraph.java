package 算法第四版.图;

import edu.princeton.cs.algs4.In;
import 算法第四版.查找.HashST;
import 算法第四版.查找.ST;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/24 15:14
 *
 * */
public class SymbolGraph extends Graph
{

    private ST<String, Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String stream, String sp)
    {
        st = new HashST<>();
        In in = new In(stream);
        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(sp);

            for (int i = 0; i < a.length; i++)
                if (!st.contains(a[i]))
                {
                    st.put(a[i], st.size());
                }
        }

        keys = new String[st.size()];

        for (String name : st.keys())
        {
            keys[st.get(name)] = name;
        }

        g = new LinkedUdGraph(st.size());
        in = new In(stream);

        while (in.hasNextLine())
        {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++)
            {
                g.addEdge(v, st.get(a[i]));
            }
        }
    }


    public boolean contains(String s)
    {
        return st.contains(s);
    }

    public int index(String s)
    {
        return st.get(s);
    }

    public String name(int v)
    {
        return keys[v];
    }

    public Graph G()
    {
        return g;
    }

    @Override
    int V()
    {
        return 0;
    }

    @Override
    int E()
    {
        return 0;
    }

    @Override
    void addEdge(int v, int w)
    {

    }

    @Override
    Iterable<Integer> adj(int v)
    {
        return null;
    }
}
