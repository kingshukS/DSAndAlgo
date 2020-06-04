package DSAndAlgo;

class Node {
    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}

public class MaximumPathSum {

    private static int finalSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(2));
        root.setRight(new Node(10));
        root.getLeft().setLeft(new Node(20));
        root.getLeft().setRight(new Node(1));
        root.getRight().setRight(new Node(-25));
        root.getRight().getRight().setLeft(new Node(3));
        root.getRight().getRight().setRight(new Node(4));

        System.out.println("Maximum Path Sum is : " + findMaximumPathSum(root));
    }

    private static int findMaximumPathSum(Node root) {
        if (root == null)
            return 0;
        if (root.getLeft() == null && root.getRight() == null)
            return root.getData();
        findMaxSumRec(root);
        return finalSum;
    }

    private static int findMaxSumRec(Node root) {
        if (root == null)
            return 0;

        int leftSum = findMaxSumRec(root.getLeft());
        int rightSum = findMaxSumRec(root.getRight());

        int S1 = Math.max(Math.max(leftSum, rightSum) + root.getData(), root.getData());
        int S2 = Math.max(S1, leftSum + rightSum + root.getData());
        finalSum = Math.max(finalSum, S2);

        return S1;
    }
}
