package 算法第四版.查找;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/23 20:44
 *
 * */
public class BST<K extends Comparable<K>, V> extends ST<K, V>
{


    private Node root;


    // 子树结构
    private class Node
    {
        private K key;
        private V val;
        private Node left, right;
        private int N;

        public Node()
        {

        }

        public Node(K key, V val, int N)
        {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public void put(K key, V val)
    {
        root = put(root, key, val);
    }


    // x 为父节点
    private Node put(Node x, K key, V val)
    {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key); //

        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private int size(Node x)
    {
        if (x == null) return 0;
        return x.N;
    }


    @Override
    public V get(K key)
    {
        return get(root, key);
    }

    private V get(Node x, K key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    @Override
    public void delete(K key)
    {

    }

    @Override
    public boolean contains(K key)
    {
        return get(key) != null;
    }

    @Override
    boolean isEmpty()
    {
        return size(root) == 0;
    }

    @Override
    public int size()
    {
        return size(root);
    }

    @Override
    K min()
    {
        return min(root).key;
    }

    private Node min(Node x)
    {
        if (x.left == null) return x;
        else return min(x.left);
    }

    @Override
    K max()
    {
        return max(root).key;
    }

    private Node max(Node x)
    {
        if (x.right == null) return x;
        else return max(x.right);
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
        return rank(key, root);
    }


    private int rank(K key, Node x)
    {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);

        if (cmp < 0) return rank(key, x.left);
        if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    @Override
    K select(int k)
    {
        return select(root, k).key;
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

    private Node select(Node x, int k)
    {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public static void main(String[] args)
    {
        BST<Integer, String> map = new BST<>();
        map.put(1, "罗瑞东");
        map.put(3, "txl");
        System.out.println(map.get(1));
        System.out.println(map.get(3));
    }
}
