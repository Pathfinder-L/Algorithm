package 算法第四版.查找;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/23 20:22
 *
 * */

import java.security.Key;

// 基于二分的符号表
public class BinaryST<K extends Comparable<K>, V> extends ST<K, V>
{
    private K[] keys;
    private V[] vals;
    private int N;

    public BinaryST(int capacity)
    {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Object[capacity];
        N = 0;
    }


    int rank(K key)
    {
        int lo = 0, hi = N - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }


    @Override
    void put(K key, V val)
    {
        int idx = rank(key);
        if (idx < N && keys[idx].compareTo(key) == 0)
        {
            vals[idx] = val;
            return;
        } else
        {
            for (int j = N; j > idx; j--)
            {
                keys[j] = keys[j - 1];
                vals[j] = vals[j - 1];
            }
            keys[idx] = key;
            vals[idx] = val;
        }
        N++;
    }

    @Override
    V get(K key)
    {
        if (isEmpty()) return null;
        int idx = rank(key);
        if (idx < N && keys[idx].compareTo(key) == 0) return vals[idx];
        else return null;
    }

    @Override
    void delete(K key)
    {
        if (isEmpty()) return;
        int idx = rank(key);
        if (idx < N && keys[idx].compareTo(key) == 0)
        {
            for (int j = idx; j < N; j++)
            {
                keys[j] = keys[j + 1];
                vals[j] = vals[j + 1];
            }
            N--;
        }
    }

    @Override
    boolean contains(K key)
    {
        if (isEmpty()) return false;
        int idx = rank(key);
        if (idx < N && keys[idx].compareTo(key) == 0) return true;
        return false;
    }

    @Override
    boolean isEmpty()
    {
        return N == 0;
    }

    @Override
    int size()
    {
        return N;
    }

    @Override
    K min()
    {
        return keys[0];
    }

    @Override
    K max()
    {
        return keys[N - 1];
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
    K select(int k)
    {
        return keys[k];
    }


    public static void main(String[] args)
    {
        BinaryST<Integer, String> map = new BinaryST<>(16);
        map.put(1, "罗瑞东1");
        map.put(2, "罗瑞东2");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.delete(1);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
