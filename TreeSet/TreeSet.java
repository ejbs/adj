import java.util.*;

public class TreeSet<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public TreeSet(T val) {
        root = new BinaryNode<T>(val, null, null);
    }
    public TreeSet() {
        root = null;
    }
    
    private int pNumberOfElements(BinaryNode<T> tree) {
        int l, r;
        l = r = 0;
        if(tree == null)
            return 0;
        if(tree.getLeft() != null)
            l = pNumberOfElements(tree.getLeft());
        if(tree.getRight() != null)
            r = pNumberOfElements(tree.getRight());
        return 1+l+r;
    }
    // O(n)
    public int numberOfElements() {
        return pNumberOfElements(root);
    }
    // O(n)
    public String toString() {
        return "[" + pToString(root) + "]";
    }
    private String pToString(BinaryNode<T> tree) {
        if(tree == null)
            return "";
        else {
            String l = pToString(tree.getLeft());
            String r = pToString(tree.getRight());
            if(!l.equals(""))
                l += ",";
            if(!r.equals(""))
                r = ","+r;
            
            return l + tree.getValue().toString() + r;
        }
    } 
    // O(n)
    public int numberOfLeaves() {
        return pNumberOfLeaves(root);
    }
    private int pNumberOfLeaves(BinaryNode<T> n) {
        if(n == null) return 0;
        if(n.getLeft() == null && n.getRight() == null)
            return 1;
        else {
            return pNumberOfLeaves(n.getLeft()) + pNumberOfLeaves(n.getRight());
        }
    }
    private int pDepth(BinaryNode<T> n) {
        if(n == null) {
            return 0;
        }
        else {
            return 1 + Math.max(pDepth(n.getLeft()),
                                pDepth(n.getRight()));
        }
    }
    // O(n)
    public int depth() {
        return pDepth(root);
    }
    
    private BinaryNode<T> rotateLeft(BinaryNode<T> k2) {
        BinaryNode<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }
    private BinaryNode<T> rotateRight(BinaryNode<T> k1) {
        BinaryNode<T> k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }
    private void pInsert(T value) {
        BinaryNode<T> t = this.root;
        BinaryNode<T> node = new BinaryNode<T>(value, null, null);
        if(t == null) {
            this.root = node;
            return;
        }
        while(true) {
            if(node.getValue().compareTo(t.getValue()) == 0) return;
            
            else if(node.getValue().compareTo(t.getValue()) < 0) {
                if(t.getLeft() == null) {
                    t.setLeft(node);
                    return;
                }
                else {
                    t = t.getLeft();
                }
            }
            
            else {
                if(t.getRight() == null) {
                    t.setRight(node);
                    return;
                }
                else {
                    t = t.getRight();
                }
            }
        }
    }
    // O(n)
    public void insert(T value) {
        pInsert(value);
    }
    private boolean pContains(T val) {
        BinaryNode<T> t = this.root;
        if(t == null) return false;
        while(true) {
            if(t.getValue().compareTo(val) < 0) {
                if(t.getRight() == null)
                    return false;
                else
                    t = t.getRight();
            }
            if(t.getValue().compareTo(val) > 0) {
                if(t.getLeft() == null)
                    return false;
                else
                    t = t.getLeft();
            }
            else {
                return true;
            }
                
        }
    }
    // O(n)
    public boolean contains(T val) {
        return pContains(val);
    }
}
