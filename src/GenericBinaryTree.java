import java.util.LinkedList;
import java.util.Queue;
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

    public static BinaryTreeNode<Integer> createBinaryTreeLevelWise() {      // input will be inserted in the tree level wise.
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data for root node: ");

        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

            System.out.print("Enter left child node of " + frontNode.data);
            int leftChildNodeData = sc.nextInt();

            if(leftChildNodeData != -1) {
                BinaryTreeNode<Integer> leftChildNode = new BinaryTreeNode<Integer>(leftChildNodeData);
                frontNode.leftChild = leftChildNode;
                pendingNodes.add(leftChildNode);
            }

            System.out.print("Enter right child node of " + frontNode.data);
            int rightChildNodeData = sc.nextInt();

            if(rightChildNodeData != -1) {
                BinaryTreeNode<Integer> rightChildNode = new BinaryTreeNode<Integer>(rightChildNodeData);
                frontNode.rightChild = rightChildNode;
                pendingNodes.add(rightChildNode);
            }
        }

        return root;
    }

    public static int totalNumberOfNodes(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        return totalNumberOfNodes(root.leftChild) + totalNumberOfNodes(root.rightChild) + 1;    // 1 for root node itself
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

        System.out.println("Total number of nodes present in this Binary Tree is: " + totalNumberOfNodes(root));

        System.out.print("Detailed view of this Binary Tree is: ");
        viewDetailedBinaryTree(root);

        // for level wise input
        root = createBinaryTreeLevelWise();
        System.out.println("Total number of nodes present in this Binary Tree is: " + totalNumberOfNodes(root));

        System.out.print("Detailed view of this Binary Tree is: ");
        viewDetailedBinaryTree(root);
    }
}