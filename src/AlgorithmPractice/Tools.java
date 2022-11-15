package AlgorithmPractice;

public class Tools {

    public static TreeNode BinaryTree() {
        /**
         *                7
         *        4            8
         *    2      5             11
         *  1  3       6       10      13
         *                   9       12
         */
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t12 = new TreeNode(12, null, null);
        TreeNode t9 = new TreeNode(9, null, null);

        TreeNode t13 = new TreeNode(13, t12, null);
        TreeNode t10 = new TreeNode(10, t9, null);
        TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t11 = new TreeNode(11, t10, t13);
        TreeNode t5 = new TreeNode(5, t3, t6);

        TreeNode t8 = new TreeNode(8, null, t11);
        TreeNode t4 = new TreeNode(4, t2, t5);

        TreeNode root = new TreeNode(7, t4, t8);
        return root;
    }
}
