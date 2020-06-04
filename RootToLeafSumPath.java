package DSAndAlgo;

public class RootToLeafSumPath {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(8));
        root.setRight(new Node(2));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(2));

        int sum = 23;
        System.out.println("Root to Leaf Path Exist : " + rootToLeafPathExist(root, sum));
    }

    private static boolean rootToLeafPathExist(Node root, int sum) {
        if (root == null)
            return sum == 0;
        boolean leftSum = rootToLeafPathExist(root.getLeft(), sum - root.getData());
        boolean rightSum = rootToLeafPathExist(root.getRight(), sum - root.getData());

        return leftSum || rightSum;
    }
}
