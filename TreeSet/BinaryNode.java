import java.util.*;

public class BinaryNode<T extends Comparable<T>> {
    private BinaryNode<T> right;
    private BinaryNode<T> left;
    private T value;
    
    public BinaryNode(T value,BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public BinaryNode<T> getLeft() {
        return left;
    }
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }
    public BinaryNode<T> getRight() {
        return right;
    }
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
