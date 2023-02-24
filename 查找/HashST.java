package 算法第四版.查找;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/23 17:37
 *
 * */
public class HashST<K extends Comparable<K>, V> extends ST<K, V>
{

    private int N;
    private int M = 16;
    private K[] keys; // 键
    private V[] vals; // 值


    public HashST()
    {
        keys = (K[]) new Object[M];
        vals = (V[]) new Object[M];
    }

    public HashST(int size)
    {
        keys = (K[]) new Object[size];
        vals = (V[]) new Object[size];
        M = size;
    }


    // 扩容
    // 将原来的数据映射到新的大小当中
    private void resize(int size)
    {
        HashST<K, V> t;
        t = new HashST<>(size);

        for (int i = 0; i < M; i++)
        {
            if (keys[i] != null)
            {
                t.put(keys[i], vals[i]);
            }
        }

        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(K key, V val)
    {
        if (N >= M / 2) resize(2 * M);

        int i;
        // 线性探测法
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
        {
            if (keys[i].equals(key))
            {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;

        N++;
    }

    @Override
    public V get(K key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
        {
            if (keys[i].equals(key))
            {
                return vals[i];
            }
        }
        return null;
    }

    @Override
    public void delete(K key)
    {
        if (!contains(key)) return; // 判断键是否存在
        int i = hash(key);
        while (!key.equals(keys[i])) i = (i + 1) % M;

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % M;

        while (keys[i] != null)
        {
            K keyToRedo = keys[i];
            V valToRedo = vals[i];

            keys[i] = null;
            vals[i] = null;

            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    @Override
    public boolean contains(K key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
        {
            if (keys[i].equals(key)) return true;
        }
        return false;
    }

    @Override
    boolean isEmpty()
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    K min()
    {
        return null;
    }

    @Override
    K max()
    {
        return null;
    }

    @Override
    K floor()
    {
        return null;
    }

    @Override
    K ceiling(K key)
    {
        return null;
    }

    @Override
    int rank(K key)
    {
        return 0;
    }

    @Override
    protected K select(int k)
    {
        return null;
    }

    @Override
    public void deleteMin()
    {

    }

    @Override
    public void deleteMax()
    {

    }

    @Override
    public Iterable<K> keys(K lo, K hi)
    {
        return null;
    }

    @Override
    public Iterable<K> keys()
    {
        return null;
    }


    public static void main(String[] args)
    {
        HashST<Integer, String> map = new HashST<>();

        map.put(2, "罗瑞东");
        map.put(2, "张三");
        //   map.delete(2);
        System.out.println(map.get(2));

    }
}
