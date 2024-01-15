/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 15/01/24
 * Time: 20:23
 */

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> leftChild;
    BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
