package 算法第四版.查找;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/18 20:59
 *
 * */
public abstract class ST<K extends Comparable<K>, V>
{
    public abstract void put(K key, V val);

    public abstract V get(K key);

    public abstract void delete(K key);

    public abstract boolean contains(K key);

    abstract boolean isEmpty();

    public abstract int size();

    abstract K min();

    abstract K max();

    abstract K floor();

    abstract K ceiling(K key);

    abstract int rank(K key);

    abstract K select(int k);

    public abstract void deleteMin();

    public abstract void deleteMax();

    public abstract Iterable<K> keys(K lo, K hi);

    public abstract Iterable<K> keys();
}
