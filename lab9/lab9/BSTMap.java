package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (p.key.compareTo(key) == 0) {
            return  p.value;
        } else if (p.key.compareTo(key) > 0) {
            return getHelper(key, root.left);
        } else {
            return getHelper(key, root.right);
        }
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        V lookup = get(key);
        if (lookup == null) {
            size += 1;
            Node newRoot = new Node(key, value);
            if (p.key.compareTo(key) > 0) {
                newRoot.right = root;
            } else {
                newRoot.left = root;
            }
            return newRoot;
        } else {
            if (p.key.compareTo(key) > 0) {
                putHelper(key, value, p.left);
            } else if (p.key.compareTo(key) < 0) {
                putHelper(key, value, p.right);
            } else {
                p.value = value;
            }
            return root;
        }
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size += 1;
        } else {
            root = putHelper(key, value, root);
        }

    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    private Set<K> keySetHelper(Set<K> set, Node p) {
        if (p == null) {
            return set;
        }
        set.add(p.key);
        if (p.left != null) {
            set = keySetHelper(set, p.left);
        }
        if (p.right != null) {
            set = keySetHelper(set, p.right);
        }
        return set;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet();
        if (root != null) {
            set = keySetHelper(set, root);
        }
        return set;
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    private V removeHelper(K key, Node p) {
        if (p.key.compareTo(key) == 0) {
            V result = p.value;
            return result;
        }
        return null;
    }
    @Override
    public V remove(K key) {
        if (get(key) == null) {
            return null;
        }
        return removeHelper(key, root);
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
    
}
