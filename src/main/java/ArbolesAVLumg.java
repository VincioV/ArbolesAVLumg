import java.util.Scanner;

public class ArbolesAVLumg {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros que desea insertar: ");
        int n = sc.nextInt();
        System.out.println("Ingrese los " + n + " numeros:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            tree.insert(num);
        }
        tree.print();
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    void insert(int val) {
        root = insertHelper(root, val);
    }

    TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else {
            node.right = insertHelper(node.right, val);
        }
        return node;
    }

    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");
        }
    }

    void print() {
        System.out.print("Pre-order: ");
        preOrder(root);
        System.out.println();
        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();
        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();
    }
}

