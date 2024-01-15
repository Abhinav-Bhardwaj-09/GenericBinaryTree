import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * User: Abhinav Bhardwaj
 * Date: 15/01/24
 * Time: 20:23
 */

public class GenericBinaryTree {
    public static BinaryTreeNode<Integer> createBinaryTree(boolean isRoot, int parentNodeData, boolean isLeftChild) {      // in case of any other datatype, just replace Integer
        Scanner sc = new Scanner(System.in);

        if(isRoot) {
            System.out.print("Enter data for root node: ");
        }
        else {
            if(isLeftChild) {
                System.out.print("Enter data for left child of " + parentNodeData + " : ");
            }
            else {
                System.out.print("Enter data for right child of " + parentNodeData + " : ");
            }
        }

        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }
        
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        BinaryTreeNode<Integer> leftChildNode = createBinaryTree(false, data, true);
        BinaryTreeNode<Integer> rightChildNode = createBinaryTree(false, data, false);

        root.leftChild = leftChildNode;
        root.rightChild = rightChildNode;

        return root;
    }

    public static void viewDetailedBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " : ");

        if(root.leftChild != null) {
            System.out.print("L " + root.leftChild.data);
        }

        if(root.rightChild != null) {
            System.out.print(", R " + root.rightChild.data);
        }

        System.out.println();

        viewDetailedBinaryTree(root.leftChild);
        viewDetailedBinaryTree(root.rightChild);
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createBinaryTree(true, -1, true);

        viewDetailedBinaryTree(root);
    }
}