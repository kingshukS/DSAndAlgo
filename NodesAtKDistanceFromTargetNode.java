package DSAndAlgo;

public class NodesAtKDistanceFromTargetNode {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(8));
        root.setRight(new Node(2));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(2));
        root.getLeft().getRight().setLeft(new Node(15));
        root.getLeft().getRight().setRight(new Node(20));
        int k = 2;
        Node targetNode = root.getLeft();
        printKDistanceNode(root, targetNode, k);
    }

    private static int printKDistanceNode(Node root, Node targetNode, int k) {

        if (root == null)
            return -1;

        if (root == targetNode) {
            printKDistanceNodeDown(root, k);
            return 0;
        }

        int dl = printKDistanceNode(root.getLeft(), targetNode, k);
        if (dl != -1) {

            if (dl + 1 == k)
                System.out.println(root.getData());
            else
                printKDistanceNodeDown(root.getRight(), k - dl - 2);

            return dl + 1;
        }

        int dr = printKDistanceNode(root.getRight(), targetNode, k);
        if (dr != -1) {

            if (dr + 1 == k)
                System.out.println(root.getData());
            else
                printKDistanceNodeDown(root.getLeft(), k - dr - 2);

            return dr + 1;
        }

        return -1;
    }

    private static void printKDistanceNodeDown(Node root, int k) {

        if (root == null || k < 0)
            return;
        if (k == 0) {
            System.out.println(root.getData());
            return;
        }

        printKDistanceNodeDown(root.getLeft(), k - 1);
        printKDistanceNodeDown(root.getRight(), k - 1);
    }
}
