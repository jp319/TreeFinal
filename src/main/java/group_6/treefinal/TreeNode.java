package group_6.treefinal;

public class TreeNode <E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public int height = 0;

    public TreeNode(E e){
        element = e;
    }
}