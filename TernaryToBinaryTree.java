package DSAndAlgo;

// Java program to convert a ternary
// expreesion to a tree.

import java.util.LinkedList;
import java.util.Queue;

// Class to represent Tree node
class Node1 {
    char data;
    Node1 left, right;

    public Node1(char item) {
        data = item;
        left = null;
        right = null;
    }
}

// Class to convert a ternary expression to a Tree
class BinaryTree {
    // Driver program to test above function
    public static void main(String[] args) {
        String exp = "a?b?c:d:e";
        BinaryTree tree = new BinaryTree();
        char[] expression = exp.toCharArray();
        Node1 root = tree.convertExpression(expression, 0);
        tree.printTree(root);
    }

    // Function to convert Ternary Expression to a Binary
    // Tree. It return the root of tree
    Node1 convertExpression(char[] expression, int i) {
        // Base case
        if (i >= expression.length)
            return null;

        // store current character of expression_string
        // [ 'a' to 'z']
        Node1 root = new Node1(expression[i]);
        // Move ahead in str
        ++i;

        // if current character of ternary expression is '?'
        // then we add next character as a left child of
        // current node
        if (i < expression.length && expression[i] == '?')
            root.left = convertExpression(expression, i + 1);

            // else we have to add it as a right child of
            // current node expression.at(0) == ':'
        else if (i < expression.length)
            root.right = convertExpression(expression, i + 1);

        return root;
    }

    // function print tree
    public void printTree(Node1 root) {
        System.out.println("Printing.....");
        if (root == null)
            return;

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node1 root1 = queue.poll();
                System.out.print(root1.data);
                if (root1.left != null)
                    queue.add(root1.left);
                if (root1.right != null)
                    queue.add(root1.right);
            }
            System.out.println();
        }
    }
}

/* This code is contributed by Mr. Somesh Awasthi */
