package 算法第四版.查找;

import 工具.Node;

/*
 * TODO
 *  @version 1.0
 *  @author Administrator
 *  @date   2023/2/23 21:09
 *
 * */
public class RedBlackBST<K extends Comparable<K>, V> extends ST<K, V>
{

    private static final Boolean RED = true;
    private static final Boolean BLACK = false;
    private Node root;

    private class Node
    {
        K key;
        V val;
        Node left, right;
        int N;
        boolean color;

        Node(K key, V val, int N, boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node node)
    {
        if (node == null) return false;
        return node.color == RED;
    }

    Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    void flipColor(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(Node x)
    {
        if (x == null) return 0;
        return x.N;
    }

    @Override
    void put(K key, V val)
    {
        root = put(root, key, val);
        root.color = BLACK;
    }


    private Node put(Node h, K key, V val)
    {
        if (h == null) return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    V get(K key)
    {
        return get(root, key).val;
    }

    private Node get(Node h, K key)
    {
        if (h == null) return null;

        int cmp = key.compareTo(h.key);
        if (cmp < 0) return get(h.left, key);
        else if (cmp > 0) return get(h.right, key);
        return h;
    }


    @Override
    void delete(K key)
    {

    }

    @Override
    boolean contains(K key)
    {
        return false;
    }

    @Override
    boolean isEmpty()
    {
        return false;
    }

    @Override
    int size()
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
    K select(int k)
    {
        return null;
    }

    public static void main(String[] args)
    {
        RedBlackBST<Integer, String> map = new RedBlackBST<>();
        map.put(1, "罗瑞东");
        map.put(2, "txl");
        map.put(3, "txl");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
